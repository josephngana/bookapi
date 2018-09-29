/*
 * Copyright (c) 2018/09/29 3:01 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/29 2:51 PM
 */

package domain.books

import java.time.{LocalDateTime}

abstract class BookBase {
  def id: String
  def title: String
  def description: Option[String] = None
  def story: Option[String] = None
  def multimedias: List[String] = List[String]()
  def dateCreated: LocalDateTime = LocalDateTime.now
}
