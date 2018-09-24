package domain.books

import play.api.libs.json.Json

case class Subsection(id: String, title: String) extends BookBase {}

object Subsection {
  implicit val subsectionFormat = Json.format[Subsection]
}
