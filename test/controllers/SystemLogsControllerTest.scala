package controllers


import java.time.LocalDateTime

import play.api.test.Helpers._
import domain.systemlogs.SystemLogEvents
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerTest
import play.api.libs.json.Json
import play.api.test.{FakeRequest, Injecting}

class SystemLogsControllerTest extends PlaySpec with GuiceOneServerPerTest with Injecting {

  val date:LocalDateTime=LocalDateTime.now()
  val entity=SystemLogEvents("101","1","ButtonClick","action","click here",date)

  val token="hi system"

  " SystemLogsController" should {


    "Create Entity" in {
      val request = route(app, FakeRequest(POST, "/syslogs/create")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is: ", contentAsString(request))

    }


    "Read Entity" in {

      val request = route(app, FakeRequest(GET, "/syslogs/get/" + entity.siteId)
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The content is : ", contentAsString(request))


    }

    "Read Entities" in {

      val request = route(app, FakeRequest(GET, "/syslogs/getall")
        .withHeaders((AUTHORIZATION -> token))
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("the content is  : ", contentAsString(request))
    }

    "Update Entity" in {
      val updatedEntity = entity.copy(id = "little Book")
      val request = route(app, FakeRequest(POST, "/syslogs/update")
        .withJsonBody(Json.toJson(updatedEntity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println("The content is :", contentAsString(request))


    }

    "Delete Entities" in {

      val request = route(app, FakeRequest(POST, "/syslogs/delete")
        .withJsonBody(Json.toJson(entity))
        .withHeaders(AUTHORIZATION -> token)
      ).get
      status(request) mustBe OK
      contentType(request) mustBe Some("application/json")
      println(" The Content is: ", contentAsString(request))
    }
  }







  }
