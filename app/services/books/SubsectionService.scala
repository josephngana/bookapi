package services.books

import domain.books.Subsection
import services.CrudService
import services.books.impl.SubsectionServiceImpl

trait SubsectionService extends CrudService[Subsection] {

}

object SubsectionService {
  def apply: SubsectionService = new SubsectionServiceImpl()
}
