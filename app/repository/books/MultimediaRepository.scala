/*
 * Copyright (c) 2018/09/29 3:14 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/25 8:25 AM
 */

package repository.books

import domain.books.Multimedia
import repository.Repository
import repository.books.impl.cassandra.MultimediaRepositoryImpl

trait MultimediaRepository extends Repository[Multimedia] {}


object MultimediaRepository {
  def apply: MultimediaRepository = new MultimediaRepositoryImpl()
}