package repository.books.impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.{ResultSet, Table}
import com.outworkers.phantom.connectors.RootConnector
import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import com.outworkers.phantom.jdk8._
import domain.books.{Subsection}

import scala.concurrent.Future

abstract class SubsectionTable extends Table[SubsectionTable, Subsection] {

  object id extends StringColumn with PartitionKey

  object title extends StringColumn

  object description extends OptionalStringColumn

  object story extends OptionalStringColumn

  object multimedias extends ListColumn[String]

  object dateCreated extends Col[LocalDateTime]

}

abstract class SubsectionTableImpl extends SubsectionTable with RootConnector {
  override lazy val tableName = "subsections"

  def saveEntity(entity: Subsection): Future[ResultSet] = {
    insert
      .value(_.id, entity.id)
      .value(_.title, entity.title)
      .value(_.description, entity.description)
      .value(_.story, entity.story)
      .value(_.multimedias, entity.multimedias)
      .value(_.dateCreated, entity.dateCreated)
      .future()
  }

  def deleteEntity(id: String): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .future()
  }

  def getEntities: Future[Seq[Subsection]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getEntity(id: String): Future[Option[Subsection]] = {
    select
      .where(_.id.eqs(id))
      .one()
  }
}
