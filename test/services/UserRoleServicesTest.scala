package services

import java.time.LocalDateTime

import domain.users.UserRole
import org.scalatest.FunSuite
import services.users.UserRoleService
import scala.concurrent.duration._

import scala.concurrent.Await

class UserRoleServicesTest extends FunSuite{
  val date:LocalDateTime=LocalDateTime.now()
  val userRole=UserRole("12",date,"1001")
  val services=UserRoleService


  test("createUserRole")
  {
    val result = Await.result(services.apply.saveEntity(userRole), 2.minutes)
    assert(result)

  }

  test("readApiUserRole"){
    val result = Await.result(services.apply.getEntity(userRole.userId), 2.minutes)

    assert( result.get.userId=="12")
  }

  test("ApiKeysUpdate"){
    val result = Await.result(services.apply.getEntity(userRole.userId), 2.minutes)
    val updatedRole = result.get.copy(userId= "13")
    val savedResult = Await.result(services.apply.saveEntity(userRole), 2.minutes)
    val newRequest = Await.result(services.apply.getEntity(userRole.userId), 2.minutes)
    assert( newRequest.get.userId=="13")
  }

  test("readAllApiKeys"){
    val result = Await.result(services.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteApiKeys"){
    val result = Await.result(services.apply.deleteEntity(userRole), 2.minutes)
    assert(result)
  }



}
