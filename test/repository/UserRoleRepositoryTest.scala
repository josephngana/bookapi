package repository

import java.time.LocalDateTime

import domain.users.UserRole
import org.scalatest.FunSuite
import repository.users.UserRoleRepository
import scala.concurrent.duration._
import scala.concurrent.Await

class UserRoleRepositoryTest extends FunSuite{

  val date:LocalDateTime=LocalDateTime.now()
  val userRole=UserRole("12",date,"1001")
  val repository=UserRoleRepository


  test("createUserRole")
  {
    val result = Await.result(repository.apply.saveEntity(userRole), 2.minutes)
    assert(result)

  }

  test("readApiUserRole"){
    val result = Await.result(repository.apply.getEntity(userRole.userId), 2.minutes)

    assert( result.get.userId=="12")
  }

  test("UserRoleUpdate"){
    val result = Await.result(repository.apply.getEntity(userRole.userId), 2.minutes)
    val updatedUserRole = result.get.copy(userId= "13")
    val savedResult = Await.result(repository.apply.saveEntity(updatedUserRole), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updatedUserRole.userId), 2.minutes)
    assert( newRequest.get.userId=="13")
  }

  test("readAllUserRole"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteUserRole"){
    val result = Await.result(repository.apply.deleteEntity(userRole), 2.minutes)
    assert(result)
  }


}
