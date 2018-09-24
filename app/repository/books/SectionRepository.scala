package repository.books

import domain.books.Section
import repository.Repository
import repository.books.impl.cassandra.SectionRepositoryImpl

trait SectionRepository extends Repository[Section] {

}

object SectionRepository {
  def apply: SectionRepository = new SectionRepositoryImpl()
}
