package services.books.impl

import domain.books.Chapter
import repository.books.ChapterRepository
import services.books.ChapterService

import scala.concurrent.Future

class ChapterServiceImpl extends ChapterService{
  override def saveEntity(entity: Chapter): Future[Boolean] = ChapterRepository.apply.saveEntity(entity)

  override def getEntities: Future[Seq[Chapter]] = ChapterRepository.apply.getEntities

  override def getEntity(id: String): Future[Option[Chapter]] = ChapterRepository.apply.getEntity(id)

  override def deleteEntity(entity: Chapter): Future[Boolean] = ChapterRepository.apply.deleteEntity(entity)

  override def createTable: Future[Boolean] = ChapterRepository.apply.createTable
}
