package domain.security

import java.time.LocalDateTime

import play.api.libs.json.Json

case class UserToken( siteId:String="",
                      userId:String="",
                      id: String="",
                      expiryDate:LocalDateTime=LocalDateTime.now,
                      tokenValue: String="",
                      message:String="")

object UserToken {
  implicit val tokenFmt = Json.format[UserToken]
  }
