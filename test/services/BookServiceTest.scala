package services

import java.time.LocalDateTime

import domain.books.Book
import org.scalatest.FunSuite
import services.books.BookService

import scala.concurrent.duration._

import scala.concurrent.Await

class BookServiceTest  extends FunSuite{
  val dateCreated:LocalDateTime=LocalDateTime.now
  val datePublished:LocalDateTime=LocalDateTime.now()

  val book=Book("11","0101","little black book",None,None,None,None,"womens'unit","Motsepe Foundations",datePublished,dateCreated)
  val services= BookService

  test("createBook"){
    val result = Await.result(services.apply.saveEntity(book), 2.minutes)
    assert(result)
  }
  test("readBook"){
    val result = Await.result(services.apply.getEntity(book.bookId), 2.minutes)

    assert( result.get.bookTitle=="little black book")

  }

  test("BookUpdate"){
    val result = Await.result(services.apply.getEntity(book.bookId), 2.minutes)
    val updatedBook = result.get.copy(bookTitle = "little Book")
    val savedResult = Await.result(services.apply.saveEntity(updatedBook), 2.minutes)
    val newRequest = Await.result(services.apply.getEntity(updatedBook.bookId), 2.minutes)
    assert( newRequest.get.bookTitle=="little Book")
  }

  test("readAllBook"){
    val result = Await.result(services.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteBook"){
    val result = Await.result(services.apply.deleteEntity(book), 2.minutes)
    assert(result)
  }




}
