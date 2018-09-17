package repository.users.Impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import com.outworkers.phantom.jdk8._
import domain.users.UserStatus

import scala.concurrent.Future

abstract class UserStatusTable extends Table[UserStatusTable, UserStatus] {

  object userId extends StringColumn with PartitionKey

  object date extends Col[LocalDateTime]

  object status extends StringColumn

}

abstract class UserStatusTableImpl extends UserStatusTable with RootConnector {

  override lazy val tableName = "userstatus"

  def saveEntity(entity: UserStatus): Future[ResultSet] = {
    insert
      .value(_.userId, entity.userId)
      .value(_.date, entity.date)
      .value(_.status, entity.status)
      .future()
  }

  def getEntity(userId: String): Future[Option[UserStatus]] = {
    select
      .where(_.userId eqs userId)
      .one()
  }

  def getEntities: Future[Seq[UserStatus]] = {
    select
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteEntity(userId: String): Future[ResultSet] = {
    delete
      .where(_.userId eqs userId)
      .future()
  }
}