package domain.books

import java.time.LocalDateTime

import play.api.libs.json.Json

case class Multimedia(
                     multimediaId: String,
                     multimediaType: String,
                     multimediaLink: String,
                     dateCreated: LocalDateTime = LocalDateTime.now
                     )

object Multimedia {
  implicit val multimediaFormat = Json.format[Multimedia]
}
