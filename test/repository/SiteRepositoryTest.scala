package repository

import java.time.LocalDateTime

import domain.sites.Site
import org.scalatest.FunSuite
import repository.sites.SiteRepository

import scala.concurrent.duration._
import scala.concurrent.Await

class SiteRepositoryTest extends FunSuite{

  val dateCreated:LocalDateTime = LocalDateTime.now
  val site=Site("001","publisher",Some("this is publisher's site"),dateCreated)
  val repository=SiteRepository


  test("createSite")
  {
    val result = Await.result(repository.apply.saveEntity(site), 2.minutes)
    assert(result)

  }

  test("readSite"){
    val result = Await.result(repository.apply.getEntity(site.siteId), 2.minutes)

    assert( result.get.siteName=="publisher")
  }

  test("SiteUpdate"){
    val result = Await.result(repository.apply.getEntity(site.siteId), 2.minutes)
    val updatedSite = result.get.copy(siteName= "editor")
    val savedResult = Await.result(repository.apply.saveEntity(updatedSite), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(site.siteId), 2.minutes)
    assert( newRequest.get.siteName=="editor")
  }

  test("readAllSite"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteSite"){
    val result = Await.result(repository.apply.deleteEntity(site), 2.minutes)
    assert(result)
  }



}
