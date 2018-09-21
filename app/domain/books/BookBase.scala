package domain.books

import java.time.{LocalDateTime}

abstract class BookBase {
  def id: String
  def title: String
  def description: Option[String] = None
  def story: Option[String] = None
  def dateCreated: LocalDateTime = LocalDateTime.now
}
