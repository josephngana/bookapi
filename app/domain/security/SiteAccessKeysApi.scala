package domain.security

import java.time.LocalDateTime

import play.api.libs.json.Json

case class SiteAccessKeysApi(siteId: String="",
                             id: String="",
                             expiryDate:LocalDateTime=LocalDateTime.now(),
                             value:String="",
                             message:String="")

object SiteAccessKeysApi {
  implicit val tokenFmt = Json.format[SiteAccessKeysApi]
}
