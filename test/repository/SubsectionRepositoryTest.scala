package repository

import java.time.LocalDateTime

import domain.books.Subsection
import org.scalatest.FunSuite
import repository.books.SubsectionRepository

import scala.concurrent.duration._
import scala.concurrent.Await

class SubsectionRepositoryTest extends FunSuite{
  val dateCreated:LocalDateTime=LocalDateTime.now
  val subsection=Subsection("20","21","domestic and sexual abuse",None,None,dateCreated)
  val repository=SubsectionRepository

  test("createSubsection"){
    val result = Await.result(repository.apply.saveEntity(subsection), 2.minutes)
    assert(result)
  }
  test("readSubsection"){
    val result = Await.result(repository.apply.getEntity(subsection.sectionId), 2.minutes)
    assert( result.get.subsectionTitle=="domestic and sexual abuse")

  }

  test("SubsectionUpdate"){
    val result = Await.result(repository.apply.getEntity(subsection.sectionId), 2.minutes)
    val updateSubsection= result.get.copy(subsectionTitle = "sexual harassment")
    val savedResult = Await.result(repository.apply.saveEntity(updateSubsection), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updateSubsection.sectionId), 2.minutes)
    assert( newRequest.get.subsectionTitle=="sexual harassment")
  }

  test("readAllMultimedia"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteMultimedia"){
    val result = Await.result(repository.apply.deleteEntity(subsection), 2.minutes)
    assert(result)
  }

}
