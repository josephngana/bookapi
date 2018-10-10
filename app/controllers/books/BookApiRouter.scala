package controllers.books

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class BookApiRouter @Inject() (
                                bookController: BookController,
                                chapterController: ChapterController
                              ) extends SimpleRouter {
  override def routes: Routes = {

    //For Books
    case GET(p"/getall") => bookController.getEntities // for super admin
    case GET(p"/site/getall/$siteId") => bookController.getSiteEntities(siteId)
    case GET(p"/site/book/get/$id") => bookController.getEntity(id)
    case POST(p"/site/book/create") => bookController.create
    case POST(p"/site/book/update") => bookController.update
    case POST(p"/site/book/delete") => bookController.delete

      // For Chapters
    case GET(p"/chapters/getall") => chapterController.getEntities // for super admin
    case GET(p"/site/chapters/getforids/$ids") => chapterController.getEntitiesForIds(ids)
    case GET(p"/site/chapter/get/$id") => chapterController.getEntity(id)
    case POST(p"/site/chapter/create") => chapterController.create
    case POST(p"/site/chapter/update") => chapterController.update
    case POST(p"/site/chapter/delete") => chapterController.delete
  }



}
