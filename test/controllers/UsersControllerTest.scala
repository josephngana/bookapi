package controllers

import java.time.LocalDateTime

import domain.users.User
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerTest
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class UsersControllerTest extends PlaySpec with GuiceOneServerPerTest {
  val dateCreated:LocalDateTime=LocalDateTime.now()

  val entity=User("10001","djannyngana@outlook.com","14",Some("john"), None, Some("Doe"),"dog",dateCreated)
  val token="the is user 1"
  " UsersController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/users/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/users/get/" + entity.userId)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/users/getall")
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(userId= "10001")
      val request = route(app, FakeRequest(POST, "/users/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/users/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }
  }




}
