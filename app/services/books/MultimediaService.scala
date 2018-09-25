package services.books

import domain.books.Multimedia
import services.CrudService
import services.books.impl.MultimediaServiceImpl

trait MultimediaService extends CrudService[Multimedia] {}

object MultimediaService {
  def apply: MultimediaService = new MultimediaServiceImpl()
}
