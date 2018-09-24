package repository.books.impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.{ResultSet, Table}
import com.outworkers.phantom.connectors.RootConnector
import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import domain.books.Chapter

import scala.concurrent.Future

abstract class ChapterTable extends Table[ChapterTable, Chapter] {

  object id extends StringColumn with PrimaryKey

  object title extends StringColumn

  object description extends OptionalStringColumn

  object story extends OptionalStringColumn

  object sectionIds extends ListColumn[String]

  object dateCreated extends Col[LocalDateTime]

}

abstract class ChapterTableImpl extends ChapterTable with RootConnector {

  override lazy val tableName = "chapters"

  def saveEntity(entity: Chapter): Future[ResultSet] = {
    insert
      .value(_.id, entity.id)
      .value(_.title, entity.title)
      .value(_.description, entity.description)
      .value(_.story, entity.story)
      .value(_.sectionIds, entity.sectionIds)
      .value(_.dateCreated, entity.dateCreated)
      .future()
  }

  def deleteEntity(id: String): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .future()
  }

  def getEntities: Future[Seq[Chapter]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getEntity(id: String): Future[Option[Chapter]] = {
    select
      .where(_.id.eqs(id))
      .one()
  }

}
