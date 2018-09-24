package repository.books

import domain.books.Chapter
import repository.Repository
import repository.books.impl.cassandra.ChapterRepositoryImpl

trait ChapterRepository extends Repository[Chapter] {}

object ChapterRepository {
  def apply: ChapterRepository = new ChapterRepositoryImpl()
}
