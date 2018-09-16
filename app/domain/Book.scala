package domain

import java.time.LocalTime

import play.api.libs.json.Json

case class Book(
                 id: String,
                 title: String,
                 override val description: String = "",
                 override val story: String = "",
                 isbn: String,
                 datePublished: LocalTime,
               ) extends BookBase {}

object Book {
  implicit val bookFormat = Json.format[Book]
}

