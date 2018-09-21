package services.books

import domain.books.Book
import services.CrudService
import services.books.impl.BookServiceImpl

trait BookService extends CrudService[Book] {

}

object BookService {
  def apply: BookService = new BookServiceImpl()
}
