package controllers

import domain.books.Section
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._


class SectionControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting {

  val entity=Section("19","how to do CPR",List("18","28","34"))
  val token="this is a section"

  " SystemLogsController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/books/site/section/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/books/site/section/get/" + entity.id)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/books/site/sections/getforids/")
        .withHeaders((AUTHORIZATION -> token))
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(title= "health assessment")
      val request = route(app, FakeRequest(POST, "/books/site/section/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/books/site/section/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }
  }












}
