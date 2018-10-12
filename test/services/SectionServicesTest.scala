package services

import java.time.LocalDateTime

import domain.books.Section
import org.scalatest.FunSuite
import services.books.SectionService

import scala.concurrent.duration._
import scala.concurrent.Await

class SectionServicesTest extends FunSuite{


  val dateCreated:LocalDateTime=LocalDateTime.now
  val section=Section("19","1010","how to do CPR",None,None,dateCreated)
  val services= SectionService

  test("createSection"){
    val result = Await.result(services.apply.saveEntity(section), 2.minutes)
    assert(result)
  }
  test("readSection"){
    val result = Await.result(services.apply.getEntity(section.chapterId), 2.minutes)

    assert( result.get.sectionTitle=="how to do CPR")

  }

  test("SectionUpdate"){
    val result = Await.result(services.apply.getEntity(section.chapterId), 2.minutes)
    val updateSection= result.get.copy(sectionTitle = "health assessments")
    val savedResult = Await.result(services.apply.saveEntity(updateSection), 2.minutes)
    val newRequest = Await.result(services.apply.getEntity(updateSection.chapterId), 2.minutes)
    assert( newRequest.get.sectionTitle=="health assessments")
  }

  test("readAllSection"){
    val result = Await.result(services.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteSection"){
    val result = Await.result(services.apply.deleteEntity(section), 2.minutes)
    assert(result)
  }


}
