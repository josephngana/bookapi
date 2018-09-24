package services.books.impl

import domain.books.Subsection
import repository.books.SubsectionRepository
import services.books.SubsectionService

import scala.concurrent.Future

class SubsectionServiceImpl extends SubsectionService {
  override def saveEntity(entity: Subsection): Future[Boolean] = SubsectionRepository.apply.saveEntity(entity)

  override def getEntities: Future[Seq[Subsection]] = SubsectionRepository.apply.getEntities

  override def getEntity(id: String): Future[Option[Subsection]] = SubsectionRepository.apply.getEntity(id)

  override def deleteEntity(entity: Subsection): Future[Boolean] = SubsectionRepository.apply.deleteEntity(entity)

  override def createTable: Future[Boolean] = SubsectionRepository.apply.createTable
}
