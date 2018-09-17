package domain.roles

import play.api.libs.json.Json

case class Role(id: String="", roleName: String="", description:String="")

object Role {

  implicit val rolesFmt = Json.format[Role]

}
