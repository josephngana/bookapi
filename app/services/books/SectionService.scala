package services.books

import domain.books.Section
import services.CrudService
import services.books.impl.SectionServiceImpl

trait SectionService extends CrudService[Section] {

}

object SectionService {
  def apply: SectionService = new SectionServiceImpl()
}
