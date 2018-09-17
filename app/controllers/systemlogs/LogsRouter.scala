package controllers.systemlogs

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


class LogsRouter@Inject()
(logEventsController: SystemLogEventsController) extends SimpleRouter {
  override def routes: Routes = {
    //ROLES
    case GET(p"/getall") =>
      logEventsController.getEntities
    case GET(p"/get/$id") =>
      logEventsController.getEntity(id)
    case POST(p"/create") =>
      logEventsController.create
    case POST(p"/update") =>
      logEventsController.update
    case POST(p"/delete") =>
      logEventsController.deleteEntity
  }
}