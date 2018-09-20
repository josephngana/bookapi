package services.security

import domain.security.UserToken
import services.CrudService
import services.security.Impl.UserTokenServiceImpl

trait UserTokenService extends CrudService[UserToken]{

}

object UserTokenService{
  def apply: UserTokenService = new UserTokenServiceImpl()
}