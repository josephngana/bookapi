package repository
import java.time.LocalDateTime

import domain.books.Chapter
import org.scalatest.FunSuite
import repository.books.ChapterRepository

import scala.concurrent.Await
import scala.concurrent.duration._

class ChapterRepositoryTest  extends FunSuite{

  val dateCreated:LocalDateTime=LocalDateTime.now
  val chapter = Chapter("18","21","emergencies",None,None,dateCreated)
  val repository= ChapterRepository



  test("createChapter"){
    val result = Await.result(repository.apply.saveEntity(chapter), 2.minutes)
    assert(result)
  }
  test("readChapter"){
    val result = Await.result(repository.apply.getEntity(chapter.bookId), 2.minutes)

    assert( result.get.chapterTitle=="emergencies")

  }

  test("ChapterUpdate"){
    val result = Await.result(repository.apply.getEntity(chapter.bookId), 2.minutes)
    val updateChapter= result.get.copy(chapterTitle = "Health")
    val savedResult = Await.result(repository.apply.saveEntity(updateChapter), 2.minutes)
    val newRequest = Await.result(repository.apply.getEntity(updateChapter.bookId), 2.minutes)
    assert( newRequest.get.chapterTitle=="Health")
  }

  test("readAllChapter"){
    val result = Await.result(repository.apply.getEntities, 2.minutes)
    assert(result.size>0)
  }

  test("deleteChapter"){
    val result = Await.result(repository.apply.deleteEntity(chapter), 2.minutes)
    assert(result)
  }


}
