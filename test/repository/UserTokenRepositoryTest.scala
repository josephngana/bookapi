package repository

import java.time.LocalDateTime

import domain.security.UserToken
import org.scalatest.FunSuite
import repository.security.UserTokenRepository
import scala.concurrent.duration._


import scala.concurrent.Await

class UserTokenRepositoryTest extends FunSuite{

  val expiryDate:LocalDateTime=LocalDateTime.now
  val userToken=UserToken("100","001","120",expiryDate,"123token","valid Token")
  val repository=UserTokenRepository


  test("createUserToken")
  {
    val result = Await.result(repository.apply.saveEntity(userToken), 2.minutes)
    assert(result)

  }

  test("readUserToken"){
    val result = Await.result(repository.apply.getEntity(userToken.userId), 2.minutes)

    assert( result.get.tokenValue=="123token")
  }

  test("UserTokenUpdate"){
    val result = Await.result(repository.apply.getEntity(userToken.userId), 2.minutes)
    val updateUserToken = result.get.copy(tokenValue= "1234token")
    val savedResult = Await.result(repository.apply.saveEntity(updateUserToken), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updateUserToken.userId), 2.minutes)
    assert( newRequest.get.tokenValue=="1234token")
  }

  test("readAllUserToken"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteUserToken") {
    val result = Await.result(repository.apply.deleteEntity(userToken), 2.minutes)
    assert(result)


  }


}
