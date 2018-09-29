/*
 * Copyright (c) 2018/09/29 3:01 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/25 9:07 AM
 */

package domain.books

import play.api.libs.json.Json

/**
  *
  * @param id
  * @param title
  * @param sectionIds
  */
case class Chapter(
                    id: String,
                    title: String,
                    sectionIds: List[String] = List[String]()
                  ) extends BookBase {}

object Chapter {
  implicit val chapterFormat = Json.format[Chapter]
}