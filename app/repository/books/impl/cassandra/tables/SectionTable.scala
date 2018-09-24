package repository.books.impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.{ResultSet, Table}
import com.outworkers.phantom.connectors.RootConnector
import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import com.outworkers.phantom.jdk8._
import domain.books.Section

import scala.concurrent.Future

abstract class SectionTable extends Table[SectionTable, Section] {

  object id extends StringColumn with PartitionKey

  object title extends StringColumn

  object description extends OptionalStringColumn

  object story extends OptionalStringColumn

  object subsectionIds extends ListColumn[String]

  object dateCreated extends Col[LocalDateTime]

}

abstract class SectionTableImpl extends SectionTable with RootConnector {

  override lazy val tableName = "sections"

  def saveEntity(entity: Section): Future[ResultSet] = {
    insert
      .value(_.id, entity.id)
      .value(_.title, entity.title)
      .value(_.description, entity.description)
      .value(_.story, entity.story)
      .value(_.subsectionIds, entity.subsectionIds)
      .value(_.dateCreated, entity.dateCreated)
      .future()
  }

  def deleteEntity(id: String): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .future()
  }

  def getEntities: Future[Seq[Section]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getEntity(id: String): Future[Option[Section]] = {
    select
      .where(_.id.eqs(id))
      .one()
  }
}
