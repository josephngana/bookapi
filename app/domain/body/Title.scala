package domain.body

import java.time.LocalDateTime

import play.api.libs.json.Json

case class Title(sectionId: String, titleId: String, titleName: String, titleDescription: String = "", dateCreated: LocalDateTime = LocalDateTime.now, isActive: Boolean = true)

object Title{
  implicit val titleFormat = Json.format[Title]
}