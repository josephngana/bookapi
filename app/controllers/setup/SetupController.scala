package controllers.setup

import javax.inject.Inject
import play.api.mvc._
import services.setup.CassandraSetupService

import scala.concurrent.{ExecutionContext}

/**
  * @author caniksea
  * @param cc
  */
class SetupController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  /**
    * create tables
    * @return
    */
  def createTables: Action[AnyContent] = Action.async{
    implicit request: Request[AnyContent] =>
      val tablesCreation = CassandraSetupService.apply.createTables
      tablesCreation map ( result => Ok(" Tables Created: "+ result))
  }

}
