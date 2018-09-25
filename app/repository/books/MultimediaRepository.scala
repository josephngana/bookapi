package repository.books

import domain.books.Multimedia
import repository.Repository
import repository.books.impl.cassandra.MultimediaRepositoryImpl

trait MultimediaRepository extends Repository[Multimedia] {}


object MultimediaRepository {
  def apply: MultimediaRepository = new MultimediaRepositoryImpl()
}