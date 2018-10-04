package repository

import java.time.LocalDateTime

import domain.systemlogs.SystemLogEvents
import org.scalatest.FunSuite
import repository.systemlogs.SystemLogEventsRepository
import scala.concurrent.duration._

import scala.concurrent.Await

class SystemLogEventRepositoryTest extends FunSuite {
  val date:LocalDateTime=LocalDateTime.now()
  val systemLogEvents=SystemLogEvents("101","1","ButtonClick","action","click here",date)
  val repository=SystemLogEventsRepository


  test("createSystemLogEvents")
  {

    val result = Await.result(repository.apply.saveEntity(systemLogEvents), 2.minutes)
    assert(result)

  }



  test("readSystemLogEvents"){
    val result = Await.result(repository.apply.getEntity(systemLogEvents.id), 2.minutes)

    assert( result.get.id=="1")
  }

  test("SystemLogEventsUpdate"){
    val result = Await.result(repository.apply.getEntity(systemLogEvents.id), 2.minutes)
    val updateSystemLogEvent = result.get.copy(id= "2")
    val savedResult = Await.result(repository.apply.saveEntity(updateSystemLogEvent), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updateSystemLogEvent.id), 2.minutes)
    assert( newRequest.get.id=="2")
  }

  test("readAllSystemLogEvents"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteSystemLogEvents"){
    val result = Await.result(repository.apply.deleteEntity(systemLogEvents), 2.minutes)
    assert(result)
  }


}
