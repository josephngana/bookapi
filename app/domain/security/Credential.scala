package domain.security

import play.api.libs.json.Json

case class Credential(email:String ="", siteId:String="", password:String="")

object Credential {
  implicit val credentialFmt = Json.format[Credential]
}
