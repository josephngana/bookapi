package repository.roles.Impl.cassandra.tables

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import domain.roles.Role

import scala.concurrent.Future

abstract class RoleTable extends Table[RoleTable, Role] with RootConnector {

  override lazy val tableName = "roles"

  object id extends StringColumn with PartitionKey

  object roleName extends StringColumn

  object description extends StringColumn


  def saveEntity(entity: Role): Future[ResultSet] = {
    insert
      .value(_.id, entity.id)
      .value(_.roleName, entity.roleName)
      .value(_.description, entity.description)
      .future()
  }

  def getEntity(id: String): Future[Option[Role]] = {
    select
      .where(_.id eqs id)
      .one()
  }

  def getEntities: Future[Seq[Role]] = {
    select
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteEntity(id: String): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .future()
  }
}