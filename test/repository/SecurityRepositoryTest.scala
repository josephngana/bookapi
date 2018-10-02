package repository

import java.time.LocalDateTime

import domain.security.ApiKeys
import org.scalatest.FunSuite
import repository.security.ApiKeysRepository

import scala.concurrent.Await
import scala.concurrent.duration._


class SecurityRepositoryTest extends FunSuite{
  val date:LocalDateTime=LocalDateTime.now()

  val apiKeys = ApiKeys("3","ADMIN","This is The Admin ApiKeys",date)
  val security= ApiKeysRepository

  test("createApikeys")
  {
    val result = Await.result(security.apply.saveEntity(apiKeys), 2.minutes)
    assert(result)

  }



}
