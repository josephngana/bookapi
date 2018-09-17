package controllers.roles

import domain.roles.Role
import domain.security.TokenFailExcerption
import javax.inject.Inject
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import services.roles.RoleService
import scala.concurrent.ExecutionContext.Implicits.global

class RoleController @Inject()
(cc: ControllerComponents) extends AbstractController(cc)  {

  def create: Action[JsValue] = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Role](input).get
      val response = for {
//        auth <- TokenCheckService.apply.getLoginStatus(request)
        results <- RoleService.apply.saveEntity(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case tokenCheckFailed: TokenFailExcerption => Unauthorized
          case otherException: Exception => InternalServerError
        }
  }

  def update: Action[JsValue] = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Role](input).get
      val response = for {
        //        auth <- TokenCheckService.apply.getToken(request)
        results <- RoleService.apply.saveEntity(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case tokenCheckFailed: TokenFailExcerption => Unauthorized
          case otherException: Exception => InternalServerError
        }
  }

  def getRole(id: String): Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent]=>
      val input = request.body
      val response = for {
        //        auth <- TokenCheckService.apply.getTokenFromParam(request)
        results <- RoleService.apply.getEntity(id)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover {
          case tokenCheckFailed: TokenFailExcerption => Unauthorized
          case otherException: Exception => InternalServerError
        }
  }

  def getRoles: Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent]=>
      val input = request.body
      val response = for {
        //        auth <- TokenCheckService.apply.getTokenFromParam(request)
        results <- RoleService.apply.getEntities
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover {
          case tokenCheckFailed: TokenFailExcerption => Unauthorized
          case otherException: Exception => InternalServerError
        }
  }

  def deleteRole: Action[JsValue] = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Role](input).get
      val response = for {
        //        auth <- TokenCheckService.apply.getTokenFromParam(request)
        results <- RoleService.apply.deleteEntity(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover {
          case tokenCheckFailed: TokenFailExcerption => Unauthorized
          case otherException: Exception => InternalServerError
        }
  }
}
