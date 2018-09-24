package services.books.impl

import domain.books.Section
import repository.books.SectionRepository
import services.books.SectionService

import scala.concurrent.Future

class SectionServiceImpl extends SectionService{
  override def saveEntity(entity: Section): Future[Boolean] = SectionRepository.apply.saveEntity(entity)

  override def getEntities: Future[Seq[Section]] = SectionRepository.apply.getEntities

  override def getEntity(id: String): Future[Option[Section]] = SectionRepository.apply.getEntity(id)

  override def deleteEntity(entity: Section): Future[Boolean] = SectionRepository.apply.deleteEntity(entity)

  override def createTable: Future[Boolean] = SectionRepository.apply.createTable
}
