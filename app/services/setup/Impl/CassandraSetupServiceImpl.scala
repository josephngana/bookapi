package services.setup.Impl

import services.books.BookService
import services.mail.MailApiService
import services.roles.RoleService
import services.security.{ApiKeysService, UserTokenService}
import services.setup.CassandraSetupService
import services.systemlogs.SystemLogEventsService
import services.users.{UserRoleService, UserService}

import scala.concurrent.Future

class CassandraSetupServiceImpl extends CassandraSetupService {
  override def createTables: Future[Boolean] = {
    RoleService.apply.createTable
    ApiKeysService.apply.createTable
    UserTokenService.apply.createTable
    SystemLogEventsService.apply.createTable
    UserRoleService.apply.createTable
    UserService.apply.createTable
    MailApiService.apply.createTable
    BookService.apply.createTable
  }
}
