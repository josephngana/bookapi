package domain.books

import java.time.LocalDateTime

import play.api.libs.json.Json

case class Book(
                 siteId: String,
                 id: String,
                 title: String,
                 isbn: String,
                 eisbn: String,
                 author: String,
                 publisher: String,
                 datePublished: LocalDateTime,
                 chapterIds: List[String] = List[String]()
               ) extends BookBase {}

object Book {
  implicit val bookFormat = Json.format[Book]
}

