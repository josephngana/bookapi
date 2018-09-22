package controllers.setup

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


class SetupRouter @Inject() (setupController: SetupController) extends SimpleRouter {
  override def routes: Routes = {
    case GET(p"/tables/create") => setupController.createTables
  }
}
