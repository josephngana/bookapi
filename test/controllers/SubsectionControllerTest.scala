package controllers

import domain.books.Subsection
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._


class SubsectionControllerTest extends PlaySpec with GuiceOneAppPerTest with Injecting{

  val entity=Subsection("20","domestic and sexual abuse")
  val token="this is a subsection"

  " SubsectionController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/books/site/subsection/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/books/site/subsection/get/" + entity.id)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/books/site/subsections/getforids/")
        .withHeaders((AUTHORIZATION -> token))
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(title= "sexual harassment")
      val request = route(app, FakeRequest(POST, "/books/site/subsection/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/books/site/subsection/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }
  }

}
