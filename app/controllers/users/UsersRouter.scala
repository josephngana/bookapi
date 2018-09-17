package controllers.users

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


class UsersRouter@Inject()
(userController: UserController) extends SimpleRouter {
  override def routes: Routes = {
    //USER
    case GET(p"/getall") =>
      userController.getEntities
    case GET(p"/get/$id") =>
      userController.getEntity(id)
    case POST(p"/create") =>
      userController.create
    case POST(p"/update") =>
      userController.update
    case POST(p"/delete") =>
      userController.deleteEntity


  }
}