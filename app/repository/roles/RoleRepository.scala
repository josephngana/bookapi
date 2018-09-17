package repository.roles

import domain.roles.Role
import repository.Repository
import repository.roles.Impl.cassandra.RoleRepositoryImpl

trait RoleRepository extends Repository[Role]{}

object RoleRepository {
  def apply: RoleRepository = new RoleRepositoryImpl()
}
