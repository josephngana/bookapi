package services.users.Impl

import domain.users.UserRole
import repository.users.UserRoleRepository
import services.users.UserRoleService

import scala.concurrent.Future

class UserRoleServiceImpl extends UserRoleService{
  override def saveEntity(entity: UserRole): Future[Boolean] = {
    UserRoleRepository.apply.saveEntity(entity)
  }

  override def getEntities: Future[Seq[UserRole]] = {
    UserRoleRepository.apply.getEntities
  }

  override def getEntity(id: String): Future[Option[UserRole]] = {
    UserRoleRepository.apply.getEntity(id)
  }

  override def deleteEntity(entity: UserRole): Future[Boolean] = {
    UserRoleRepository.apply.deleteEntity(entity)
  }

  override def createTable: Future[Boolean] = {
    UserRoleRepository.apply.createTable
  }
}
