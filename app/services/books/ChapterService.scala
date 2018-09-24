package services.books

import domain.books.Chapter
import services.CrudService
import services.books.impl.ChapterServiceImpl

trait ChapterService extends CrudService[Chapter]{

}

object ChapterService {
  def apply: ChapterService = new ChapterServiceImpl()
}
