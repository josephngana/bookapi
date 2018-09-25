package domain.books

import play.api.libs.json.Json

case class Section(
                    id: String,
                    title: String,
                    subsectionIds: List[String] = List[String]()
                  ) extends BookBase {}

object Section {
  implicit val sectionFormat = Json.format[Section]
}
