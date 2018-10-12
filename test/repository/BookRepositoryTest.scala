package repository

import java.time.LocalDateTime

import domain.books.Book
import org.scalatest.FunSuite
import repository.books.BookRepository
import scala.concurrent.duration._

import scala.concurrent.Await

class BookRepositoryTest extends FunSuite{
  val dateCreated:LocalDateTime=LocalDateTime.now
  val datePublished:LocalDateTime=LocalDateTime.now()

  val book=Book("11","0101","little black book",None,None,None,None,"womens'unit","Motsepe Foundations",datePublished,dateCreated)
  val repository=BookRepository

  test("createBook"){
    val result = Await.result(repository.apply.saveEntity(book), 2.minutes)
    assert(result)
  }
  test("readBook"){
    val result = Await.result(repository.apply.getEntity(book.bookId), 2.minutes)

    assert( result.get.bookTitle=="little black book")

  }

  test("BookUpdate"){
    val result = Await.result(repository.apply.getEntity(book.bookId), 2.minutes)
    val updatedBook = result.get.copy(bookTitle = "little Book")
    val savedResult = Await.result(repository.apply.saveEntity(updatedBook), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updatedBook.bookId), 2.minutes)
    assert( newRequest.get.bookTitle=="little Book")
  }

  test("readAllBook"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteBook"){
    val result = Await.result(repository.apply.deleteEntity(book), 2.minutes)
    assert(result)
  }



}
