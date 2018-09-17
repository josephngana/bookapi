package domain.mail

import play.api.libs.json.Json

/**
  *
  * @param id for the Provider eg SendGrid
  * @param key value for the Key
  */

case class MailApi(id:String="Provider", key:String="",sender:String="")

object MailApi{
  implicit val mailFmt = Json.format[MailApi]
}
