package domain

import java.time.LocalTime

import play.api.libs.json.Json

case class Book(
                 override val id: String,
                 override val title: String,
                 override val description: String = "",
                 override val story: String = "",
                 isbn: String,
                 datePublished: LocalTime,
               ) extends BookBase(id, title, description, story) {}

object Book {
  implicit val bookFormat = Json.format[Book]
}

