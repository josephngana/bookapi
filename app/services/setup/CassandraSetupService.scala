package services.setup

import services.setup.Impl.CassandraSetupServiceImpl

import scala.concurrent.Future

trait CassandraSetupService {
  def createTables:Future[Boolean]

}

object  CassandraSetupService{
  def apply: CassandraSetupService = new CassandraSetupServiceImpl()
}
