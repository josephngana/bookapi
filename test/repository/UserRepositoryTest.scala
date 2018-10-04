package repository

import java.time.LocalDateTime

import domain.users.User
import org.scalatest.FunSuite
import repository.users.UserRepository

import scala.concurrent.duration._
import scala.concurrent.Await

class UserRepositoryTest extends FunSuite{

  val dateCreated:LocalDateTime=LocalDateTime.now()

  val user=User("10001","djannyngana@outlook.com","14",Some("john"), None, Some("Doe"),"dog",dateCreated)
  val repository=UserRepository

  test("createUser")
  {
    val result = Await.result(repository.apply.saveEntity(user), 2.minutes)
    assert(result)

  }

  test("readUser"){
    val result = Await.result(repository.apply.getEntity(user.userId), 2.minutes)

    assert( result.get.userId=="14")
  }

  test("UserUpdate"){
    val result = Await.result(repository.apply.getEntity(user.userId), 2.minutes)
    val updatedUser= result.get.copy(userId = "16")
    val savedResult = Await.result(repository.apply.saveEntity(updatedUser), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updatedUser.userId), 2.minutes)
    assert( newRequest.get.userId=="16")
  }

  test("readAllUser"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteUser") {
    val result = Await.result(repository.apply.deleteEntity(user), 2.minutes)
    assert(result)
  }



}
