package controllers

import java.time.LocalDateTime

import domain.books.Book
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Injecting}

class BookControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting{
  val dateCreated:LocalDateTime=LocalDateTime.now

  val datePublished:LocalDateTime=LocalDateTime.now()
  val entity= Book("11","0101","little black book",None,None,None,None,"womens'unit","Motsepe Foundations",datePublished,dateCreated)
  val token="hi there"

  " BookController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/books/site/book/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/books/site/getall/" + entity.bookId)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/books/getall")
        .withHeaders((AUTHORIZATION -> token))
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(bookTitle = "little Book")
      val request = route(app, FakeRequest(POST, "/books/site/book/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

         "Delete Entities" in {

           val request = route(app, FakeRequest(POST, "/books/site/book/delete")
             .withJsonBody(Json.toJson(entity))
             .withHeaders(AUTHORIZATION -> token)
           ).get
           status(request) mustBe OK
           contentType(request) mustBe Some("application/json")
           println(" The Content is: ", contentAsString(request))
         }


















  }











}
