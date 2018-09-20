package domain.books

import java.time.LocalTime

import play.api.libs.json.Json

case class Book(
                 id: String,
                 title: String,
                 isbn: String,
                 eisbn: String,
                 author: String,
                 publisher: String,
                 datePublished: LocalTime,
               ) extends BookBase {}

object Book {
  implicit val bookFormat = Json.format[Book]
}

