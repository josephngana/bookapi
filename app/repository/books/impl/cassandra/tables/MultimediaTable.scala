/*
 * Copyright (c) 2018/09/29 3:10 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/29 3:10 PM
 */

package repository.books.impl.cassandra.tables

import java.time.LocalDateTime

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import com.outworkers.phantom.jdk8._
import domain.books.Multimedia

import scala.concurrent.Future

abstract class MultimediaTable extends Table[MultimediaTable, Multimedia] {

  object multimediaId extends StringColumn with PartitionKey

  object multimediaType extends StringColumn

  object multimediaName extends StringColumn

  object multimediaLink extends StringColumn

  object dateCreated extends Col[LocalDateTime]

}

abstract class MultimediaTableImpl extends MultimediaTable with RootConnector {

  override lazy val tableName = "multimedia"

  /**
    * Save a multimedia
    * @param entity
    * @return
    */
  def saveEntity(entity: Multimedia): Future[ResultSet] = {
    insert
      .value(_.multimediaId, entity.multimediaId)
      .value(_.multimediaType, entity.multimediaType)
      .value(_.multimediaName, entity.multimediaName)
      .value(_.multimediaLink, entity.multimediaLink)
      .value(_.dateCreated, entity.dateCreated)
      .future()
  }

  /**
    * Fetch all multimedia
    * @return
    */
  def getEntities(): Future[Seq[Multimedia]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  /**
    * Get a multimedia
    * @param multimediaId
    * @return
    */
  def getEntity(multimediaId: String): Future[Option[Multimedia]] = {
    select
      .where(_.multimediaId.eqs(multimediaId))
      .one()
  }

  /**
    * Delete a multimedia
    * @param multimediaId
    * @return
    */
  def deleteEntity(multimediaId: String): Future[ResultSet] = {
    delete
      .where(_.multimediaId.eqs(multimediaId))
      .future()
  }
}
