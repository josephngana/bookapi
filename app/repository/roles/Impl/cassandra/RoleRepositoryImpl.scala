package repository.roles.Impl.cassandra

import com.outworkers.phantom.connectors.KeySpace
import com.outworkers.phantom.dsl._
import com.outworkers.phantom.database.Database
import configuration.connections.DataConnection
import domain.roles.Role
import repository.roles.Impl.cassandra.tables.RoleTableImpl
import repository.roles.RoleRepository

import scala.concurrent.Future


class RoleRepositoryImpl extends RoleRepository {

  override def createTable: Future[Boolean] = {
    implicit def keyspace: KeySpace = DataConnection.devKeySpaceQuery.keySpace
    implicit def session: Session = DataConnection.connector.session
    RoleDatabase.roleTable.create.ifNotExists().future().map(result => result.head.isExhausted())
  }

  override def saveEntity(entity: Role): Future[Boolean] = {
    RoleDatabase.roleTable.saveEntity(entity).map(result => result.isExhausted())
  }

  override def getEntities: Future[Seq[Role]] = {
    RoleDatabase.roleTable.getEntities
  }

  override def getEntity(id: String): Future[Option[Role]] = {
    RoleDatabase.roleTable.getEntity(id)
  }

  override def deleteEntity(entity: Role): Future[Boolean] = {
    RoleDatabase.roleTable.deleteEntity(entity.id).map(result => result.isExhausted())
  }
}


class RoleDatabase(override val connector: KeySpaceDef) extends Database[RoleDatabase](connector) {

  object roleTable extends RoleTableImpl with connector.Connector
}

object RoleDatabase extends RoleDatabase(DataConnection.connector)
