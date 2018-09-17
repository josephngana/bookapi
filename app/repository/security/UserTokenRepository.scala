package repository.security

import domain.security.UserToken
import repository.Repository
import repository.security.Impl.cassandra.UserTokenRepositoryImpl

import scala.concurrent.Future

trait UserTokenRepository extends Repository[UserToken] {

  def getUserTokens(userId: String): Future[Seq[UserToken]]

}

object UserTokenRepository {
  def apply: UserTokenRepository = new UserTokenRepositoryImpl()
}
