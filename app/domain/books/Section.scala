/*
 * Copyright (c) 2018/09/29 3:02 PM.
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
  * @param subsectionIds
  */
case class Section(
                    id: String,
                    title: String,
                    subsectionIds: List[String] = List[String]()
                  ) extends BookBase {}

object Section {
  implicit val sectionFormat = Json.format[Section]
}
