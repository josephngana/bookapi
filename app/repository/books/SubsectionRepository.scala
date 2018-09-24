package repository.books

import domain.books.Subsection
import repository.Repository
import repository.books.impl.cassandra.SubsectionRepositoryImpl

trait SubsectionRepository extends Repository[Subsection] {}

object SubsectionRepository {
  def apply: SubsectionRepository = new SubsectionRepositoryImpl()
}
