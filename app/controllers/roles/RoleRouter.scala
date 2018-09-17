package controllers.roles

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


class RoleRouter@Inject()
(roleController: RoleController) extends SimpleRouter {
  override def routes: Routes = {
    //ROLES
    case GET(p"/getall") =>
      roleController.getRoles
    case GET(p"/get/$id") =>
      roleController.getRole(id)
    case POST(p"/create") =>
      roleController.create
    case POST(p"/update") =>
      roleController.update
    case POST(p"/delete") =>
      roleController.deleteRole
  }
}
