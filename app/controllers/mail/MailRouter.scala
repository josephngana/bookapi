package controllers.mail

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class MailRouter@Inject()
(mailApiController: MailApiController) extends SimpleRouter {
  override def routes: Routes = {

    //MAILAPI
    case GET(p"/api/getall") =>
      mailApiController.getEntities
    case GET(p"/api/get/$id") =>
      mailApiController.getEntity(id)
    case POST(p"/api/create") =>
      mailApiController.create
    case POST(p"/api/update") =>
      mailApiController.update
    case POST(p"/api/delete") =>
      mailApiController.deleteEntity
    case POST(p"/api/send") =>
      mailApiController.deleteEntity

  }
}