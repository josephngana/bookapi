/*
 * Copyright (c) 2018/09/29 3:02 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/23 4:13 PM
 */

package domain.books

import play.api.libs.json.Json

/**
  *
  * @param id
  * @param title
  */
case class Subsection(id: String, title: String) extends BookBase {}

object Subsection {
  implicit val subsectionFormat = Json.format[Subsection]
}
