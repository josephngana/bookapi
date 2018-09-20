package services.security

import domain.security.ApiKeys
import org.jose4j.jwk.PublicJsonWebKey
import services.CrudService
import services.security.Impl.ApiKeysServiceImpl

trait ApiKeysService extends CrudService[ApiKeys]{
  def generateApiKeys(): String
  def getPublicJsonWebKey(publicApiKey: Option[ApiKeys]): PublicJsonWebKey
  def generateJsonPublicKey(phrase: String): String

}

object ApiKeysService{
  def apply: ApiKeysService = new ApiKeysServiceImpl()
}
