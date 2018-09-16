package domain

import java.time.LocalTime

import play.api.libs.json.Json

case class BookBase(id: String, title: String, description: String = "", story: String = "", dateCreated: LocalTime = LocalTime.now) {}

object BookBase {
  implicit val bookBaseFormat = Json.format[BookBase]
}
