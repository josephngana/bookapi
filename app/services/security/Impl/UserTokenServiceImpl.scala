package services.security.Impl

import domain.security.UserToken
import repository.security.UserTokenRepository
import services.security.UserTokenService

import scala.concurrent.Future

class UserTokenServiceImpl extends UserTokenService{
  override def saveEntity(entity: UserToken): Future[Boolean] = {
    UserTokenRepository.apply.saveEntity(entity)
  }

  override def getEntities: Future[Seq[UserToken]] = {
    UserTokenRepository.apply.getEntities
  }

  override def getEntity(id: String): Future[Option[UserToken]] = {
    UserTokenRepository.apply.getEntity(id)
  }

  override def deleteEntity(entity: UserToken): Future[Boolean] = {
    UserTokenRepository.apply.deleteEntity(entity)
  }

  override def createTable: Future[Boolean] = {
    UserTokenRepository.apply.createTable
  }




}
