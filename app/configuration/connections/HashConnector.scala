package configuration.connections

import java.net.InetAddress

import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy
import com.datastax.driver.core.{PoolingOptions, SocketOptions}
import com.outworkers.phantom.connectors.ContactPoints
import com.outworkers.phantom.dsl._
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConverters._


object Configuration {
  val config: Config = ConfigFactory.load()

  def PORT = 9042

  def connectionTimeoutMillis = 700000

  // Default is 5000
  def readTimeoutMillis = 1500000

  // Default is 12000
  val hosts: Seq[String] = config.getStringList("cassandra.host").asScala.toList
  val dataCenter: String = config.getString("cassandra.dataCenter")
  val inets: Seq[InetAddress] = hosts.map(InetAddress.getByName)
  val keySpace: String = config.getString("cassandra.keySpace")
  val clusterName: String = config.getString("cassandra.clusterName")
}



object DataConnection {

  val devKeySpaceQuery = KeySpace(Configuration.keySpace).ifNotExists()
    .`with`(replication eqs SimpleStrategy.replication_factor(1))
    .and(durable_writes eqs true)

  val prodKeySpaceQuery =  KeySpace(Configuration.keySpace).ifNotExists()
    .`with`(replication eqs NetworkTopologyStrategy
      .data_center("data1", 2)
      .data_center("data2", 3)
    ).and(durable_writes eqs true)

  lazy val connector = ContactPoints(Configuration.hosts, Configuration.PORT)
    .withClusterBuilder(
      _.withClusterName(Configuration.clusterName)
        .withSocketOptions(new SocketOptions()
          .setReadTimeoutMillis(Configuration.readTimeoutMillis)
          .setConnectTimeoutMillis(Configuration.connectionTimeoutMillis))
        .withPoolingOptions(new PoolingOptions()
          .setMaxQueueSize(100000)
          .setPoolTimeoutMillis(20000))
        .withLoadBalancingPolicy(
          new DCAwareRoundRobinPolicy.Builder()
            .withUsedHostsPerRemoteDc(1)
            .withLocalDc(Configuration.dataCenter).build()
        )
    ).noHeartbeat().keySpace(devKeySpaceQuery)

}
