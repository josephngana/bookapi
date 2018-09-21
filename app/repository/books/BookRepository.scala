package repository.books

import domain.books.Book
import repository.Repository
import repository.books.impl.cassandra.BookRepositoryImpl

trait BookRepository extends Repository[Book]{}

object BookRepository {
  def apply: BookRepository = new BookRepositoryImpl()
}
