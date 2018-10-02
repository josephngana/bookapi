package services.sites.impl

import domain.sites.Site
import repository.sites.SiteRepository
import services.sites.SiteService

import scala.concurrent.Future

class SiteServiceImpl extends SiteService{
  override def saveEntity(entity: Site): Future[Boolean] =
    SiteRepository.apply.saveEntity(entity)

  override def getEntities: Future[Seq[Site]] = SiteRepository.apply.getEntities

  override def getEntity(id: String): Future[Option[Site]] = SiteRepository.apply.getEntity(id)

  override def deleteEntity(entity: Site): Future[Boolean] = SiteRepository.apply.deleteEntity(entity)

  override def createTable: Future[Boolean] = SiteRepository.apply.createTable
}
