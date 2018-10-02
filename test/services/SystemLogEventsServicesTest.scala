package services

import java.time.LocalDateTime

import org.scalatest.FunSuite
import domain.systemlogs.SystemLogEvents
import services.systemlogs.SystemLogEventsService



class SystemLogEventsServicesTest extends FunSuite{

  val date:LocalDateTime=LocalDateTime.now()
  val systemLogEvents=SystemLogEvents("101","1","ButtonClick","action","click here",date)
  val services=SystemLogEventsService

  test("createSystemLogEvents")
  {

  }



}
