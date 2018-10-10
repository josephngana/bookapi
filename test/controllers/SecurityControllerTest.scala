package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerTest
import play.api.test.{FakeRequest, Injecting}
import domain.security.{ApiKeys, UserToken}
import java.time.LocalDateTime

import play.api.test.Helpers._
import play.api.libs.json.Json

class SecurityControllerTest extends PlaySpec with GuiceOneServerPerTest with Injecting{

  val expiryDate:LocalDateTime=LocalDateTime.now
  val entity = UserToken("100","001","120",expiryDate,"123token","valid Token")
  val token="security"




  " SecurityController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/security/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/security/get/" + entity.id)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/security/getall")
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(tokenValue ="1234token")
      val request = route(app, FakeRequest(POST, "/security/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/security/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }


















  }













}
