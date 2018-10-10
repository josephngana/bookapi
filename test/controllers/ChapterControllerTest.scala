package controllers

import akka.japi.Option.Some
import domain.books.Chapter
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._



class ChapterControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting {

  val entity = Chapter("18","emergencies",List("1","2","3","4","5","6","7","8"))
  val token="these are the chapters"

  "ChapterController " should {

    "Create Entity " in {
      val request=route(app, FakeRequest(POST, "/books/site/chapter/create")
          .withJsonBody(Json.toJson(entity))
          .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println ( "the content is : ", contentAsString(request))

    }

    "Read Entity" in {
      val request= route(app, FakeRequest(GET,"/books/site/chapter/get/" +entity.id)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status (request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is : " , contentAsString(request))



    }
    "Read Entities " in {
      val request =route (app, FakeRequest(GET, "/books/chapters/get/")
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
println ("The Content is : ", contentAsString(request))

    }

    "Update Entity " in {
      val updatedEntity =entity.copy(title = "Health")
      val request=route(app, FakeRequest(POST, "/books/site/chapter/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status (request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The Content is: ", contentAsString(request))


    }

    "Delete Entities " in {
      val request = route(app , FakeRequest(POST, "/books/site/chapter/delete")
          .withJsonBody(Json.toJson(entity))
          .withHeaders(AUTHORIZATION -> token)
      ).get
      status (request) mustBe OK
      contentType(request) mustBe Some("application/json")
       println("The content is : ", contentAsString(request))


    }










  }





}
