package services.security

import domain.security.ApiKeys
import services.CrudService
import services.security.Impl.ApiKeysServiceImpl

trait ApiKeysService extends CrudService[ApiKeys]{

}

object ApiKeysService{
  def apply: ApiKeysService = new ApiKeysServiceImpl()
}
