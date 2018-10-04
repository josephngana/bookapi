package controllers.books

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class BookApiRouter @Inject() (bookController: BookController) extends SimpleRouter {
  override def routes: Routes = {

    //For Books
    case GET(p"/getall") => bookController.getEntities
    case GET(p"/site/getall/$siteId") => bookController.getSiteEntities(siteId)
    case GET(p"/site/book/get/$id") => bookController.getEntity(id)
    case POST(p"/site/book/create") => bookController.create
    case POST(p"/site/book/update") => bookController.update
    case POST(p"/site/book/delete") => bookController.delete
  }
}
