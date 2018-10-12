package controllers


import java.time.LocalDateTime

import domain.books.Chapter
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._



class ChapterControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting {

   val dateCreated:LocalDateTime=LocalDateTime.now
  val entity = Chapter("18","21","emergencies",None,None,dateCreated)
  val token="these are the chapters"


  " ChapterController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/books/site/chapter/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }

    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/books/site/chapter/get/" + entity.bookId)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/books/chapters/getall/")
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(chapterTitle= "emergencies")
      val request = route(app, FakeRequest(POST, "/books/site/chapter/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/books/site/chapter/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }
  }



}
