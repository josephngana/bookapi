/*
 * Copyright (c) 2018/09/29 3:17 PM.
 * Author: caniksea
 * Project: bookapi
 * Last Modified: 2018/09/24 3:07 PM
 */

package services.books

import domain.books.Chapter
import services.CrudService
import services.books.impl.ChapterServiceImpl

trait ChapterService extends CrudService[Chapter]{

}

object ChapterService {
  def apply: ChapterService = new ChapterServiceImpl()
}
