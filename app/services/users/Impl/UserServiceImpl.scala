package services.users.Impl

import domain.users.User
import repository.users.UserRepository
import services.users.UserService

import scala.concurrent.Future

class UserServiceImpl extends UserService{
  override def saveEntity(entity: User): Future[Boolean] = {
    UserRepository.apply.saveEntity(entity)
  }

  override def getEntities: Future[Seq[User]] = {
    UserRepository.apply.getEntities
  }

  override def getEntity(userId: String): Future[Option[User]] = {
    UserRepository.apply.getEntity(userId)
  }

  override def deleteEntity(entity: User): Future[Boolean] = {
    UserRepository.apply.deleteEntity(entity)
  }

  override def createTable: Future[Boolean] = {
    UserRepository.apply.createTable
  }

}
