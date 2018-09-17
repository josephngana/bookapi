package services.roles.Impl

import domain.roles.Role
import repository.roles.RoleRepository
import services.roles.RoleService

import scala.concurrent.Future

class RoleServiceImpl extends RoleService {
  override def saveEntity(entity: Role): Future[Boolean] = {
    RoleRepository.apply.saveEntity(entity)
  }

  override def getEntities: Future[Seq[Role]] = {
    RoleRepository.apply.getEntities
  }

  override def getEntity(id: String): Future[Option[Role]] = {
    RoleRepository.apply.getEntity(id)
  }

  override def deleteEntity(entity: Role): Future[Boolean] = {
    RoleRepository.apply.deleteEntity(entity)
  }

  override def createTable: Future[Boolean] = {
    RoleRepository.apply.createTable
  }
}
