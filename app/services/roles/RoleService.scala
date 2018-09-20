package services.roles

import domain.roles.Role
import services.CrudService
import services.roles.Impl.RoleServiceImpl

trait RoleService extends CrudService[Role]{

}

object RoleService{
  def apply: RoleService = new RoleServiceImpl()
}