/*
 * Copyright (c) 2018/09/29 3:01 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/29 2:50 PM
 */
package domain.books

import java.time.LocalDateTime

import play.api.libs.json.Json

/**
  *
  * @param siteId
  * @param id
  * @param title
  * @param isbn
  * @param eisbn
  * @param author
  * @param publisher
  * @param datePublished
  * @param chapterIds
  */
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

