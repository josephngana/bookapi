package services.books.impl

import domain.books.Multimedia
import repository.books.MultimediaRepository
import services.books.MultimediaService

import scala.concurrent.Future

class MultimediaServiceImpl extends MultimediaService {
  override def saveEntity(entity: Multimedia): Future[Boolean] =
    MultimediaRepository.apply.saveEntity(entity)

  override def getEntities: Future[Seq[Multimedia]] = MultimediaRepository.apply.getEntities

  override def getEntity(id: String): Future[Option[Multimedia]] = MultimediaRepository.apply.getEntity(id)

  override def deleteEntity(entity: Multimedia): Future[Boolean] =
    MultimediaRepository.apply.deleteEntity(entity)

  override def createTable: Future[Boolean] = MultimediaRepository.apply.createTable
}
