package services.sites

import domain.sites.Site
import services.CrudService
import services.sites.impl.SiteServiceImpl

trait SiteService extends CrudService[Site] {}

object SiteService {
  def apply: SiteService = new SiteServiceImpl()
}
