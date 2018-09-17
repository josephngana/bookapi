package services.systemlogs.Impl

import domain.systemlogs.SystemLogEvents
import repository.systemlogs.SystemLogEventsRepository
import services.systemlogs.SystemLogEventsService

import scala.concurrent.Future

class SystemLogEventsServiceImpl extends SystemLogEventsService{
  override def saveEntity(entity: SystemLogEvents): Future[Boolean] = {
    SystemLogEventsRepository.apply.saveEntity(entity)
  }

  override def getEntities: Future[Seq[SystemLogEvents]] = {
    SystemLogEventsRepository.apply.getEntities
  }

  override def getEntity(id: String): Future[Option[SystemLogEvents]] = {
    SystemLogEventsRepository.apply.getEntity(id)
  }

  override def deleteEntity(entity: SystemLogEvents): Future[Boolean] = {
    SystemLogEventsRepository.apply.deleteEntity(entity)
  }

  override def createTable: Future[Boolean] = {
    SystemLogEventsRepository.apply.createTable
  }

  override def getSiteLogEvents(siteId: String): Future[Seq[SystemLogEvents]] = {
    SystemLogEventsRepository.apply.getSiteLogEvents(siteId)
  }
}
