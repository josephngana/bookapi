package controllers

import java.time.LocalDateTime

import domain.books.Book
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{FakeRequest, Injecting}

class BookControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting{
  val datePublished:LocalDateTime=LocalDateTime.now()
  val entity= Book("11","0101","little black book","978-1-928333-02-9","978-1-928333-03-6","womens's unit","Motsepe Foundation",datePublished,List("1","2","3","4","5"))
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

      val request = route(app, FakeRequest(GET, "/books/site/get/" + entity.siteId)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/books/etall")
        .withHeaders((AUTHORIZATION -> token))
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(title = "little Book")
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
