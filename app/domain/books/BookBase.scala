package domain.books

import java.time.LocalTime

abstract class BookBase() {
  def id: String
  def title: String
  def description: String = ""
  def story: String = ""
  def dateCreated: LocalTime = LocalTime.now
}
