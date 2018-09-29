/*
 * Copyright (c) 2018/09/29 3:17 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/21 10:13 AM
 */

package services.books

import domain.books.Book
import services.CrudService
import services.books.impl.BookServiceImpl

trait BookService extends CrudService[Book] {

}

object BookService {
  def apply: BookService = new BookServiceImpl()
}
