/*
 * Copyright (c) 2018/09/29 3:14 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/23 4:19 PM
 */

package repository.books

import domain.books.Chapter
import repository.Repository
import repository.books.impl.cassandra.ChapterRepositoryImpl

trait ChapterRepository extends Repository[Chapter] {}

object ChapterRepository {
  def apply: ChapterRepository = new ChapterRepositoryImpl()
}
