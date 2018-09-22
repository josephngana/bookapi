package domain.books

import java.time.LocalTime

abstract class BookBase {
  def id: String
  def title: String
  def description: Option[String] = None
  def story: Option[String] = None
  def dateCreated: LocalTime = LocalTime.now
}
