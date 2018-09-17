package services.setup.Impl

import services.mail.{MailApiService, MailConfigService, SmtpConfigService}
import services.roles.RoleService
import services.security.{ApiKeysService, SiteAccessKeysApiService, UserTokenService}
import services.setup.CassandraSetupService
import services.sites.SiteService
import services.systemlogs.SystemLogEventsService
import services.users.{UserRoleService, UserService, UserStatusService, UserPasswordService}

import scala.concurrent.Future

class CassandraSetupServiceImpl extends CassandraSetupService {
  override def createTables: Future[Boolean] = {
    RoleService.apply.createTable
    MailConfigService.apply.createTable
    SmtpConfigService.apply.createTable
    ApiKeysService.apply.createTable
    SiteAccessKeysApiService.apply.createTable
    UserTokenService.apply.createTable
    SiteService.apply.createTable
    SystemLogEventsService.apply.createTable
    UserRoleService.apply.createTable
    UserService.apply.createTable
    UserStatusService.apply.createTable
    UserPasswordService.apply.createTable
    MailApiService.apply.createTable
  }
}
