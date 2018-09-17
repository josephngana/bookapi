package repository.systemlogs.Impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import com.outworkers.phantom.jdk8._
import domain.systemlogs.SystemLogEvents

import scala.concurrent.Future

abstract class SystemLogEventsTable extends Table[SystemLogEventsTable, SystemLogEvents] {


  object siteId extends StringColumn with PartitionKey

  object id extends StringColumn with PrimaryKey

  object eventName extends StringColumn

  object eventType extends StringColumn

  object message extends StringColumn

  object date extends Col[LocalDateTime]

}

abstract class SystemLogEventsTableImpl extends SystemLogEventsTable with RootConnector {

  override lazy val tableName = "logevents"

  def saveEntity(entity: SystemLogEvents): Future[ResultSet] = {
    insert
      .value(_.siteId, entity.siteId)
      .value(_.id, entity.id)
      .value(_.eventName, entity.eventName)
      .value(_.eventType, entity.eventType)
      .value(_.message, entity.message)
      .value(_.date, entity.date)
      .future()
  }

  def getSiteLogEvents(siteId:String): Future[Seq[SystemLogEvents]] = {
    select
      .where(_.siteId eqs siteId)
      .fetchEnumerator() run Iteratee.collect()
  }

  def getEntities: Future[Seq[SystemLogEvents]] = {
    select
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteEntity(siteId:String, id: String): Future[ResultSet] = {
    delete
      .where(_.siteId eqs siteId)
      .and(_.id eqs id)
      .future()
  }
}

abstract class SystemLogEventsByIdTable extends Table[SystemLogEventsByIdTable, SystemLogEvents] {


  object siteId extends StringColumn with PrimaryKey

  object id extends StringColumn with PartitionKey

  object eventName extends StringColumn

  object eventType extends StringColumn

  object message extends StringColumn

  object date extends Col[LocalDateTime]

}

abstract class SystemLogEventsByIdTableImpl extends SystemLogEventsByIdTable with RootConnector {

  override lazy val tableName = "logeventsids"

  def saveEntity(entity: SystemLogEvents): Future[ResultSet] = {
    insert
      .value(_.siteId, entity.siteId)
      .value(_.id, entity.id)
      .value(_.eventName, entity.eventName)
      .value(_.eventType, entity.eventType)
      .value(_.message, entity.message)
      .value(_.date, entity.date)
      .future()
  }

  def getEntity(id: String): Future[Option[SystemLogEvents]] = {
    select
      .where(_.id eqs id)
      .one()
  }

  def deleteEntity(id: String): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .future()
  }
}