package domain.body

import java.time.LocalDateTime

import play.api.libs.json.Json

case class Section(sectionId: Int, sectionName: String, sectionDescripton: String = "", dateCreated: LocalDateTime = LocalDateTime.now, isActive: Boolean = true)

object Section{
  implicit val sectionFormat = Json.format[Section]
}
