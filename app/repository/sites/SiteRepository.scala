package repository.sites

import domain.sites.Site
import repository.Repository
import repository.sites.impl.cassandra.SiteRepositoryImpl

trait SiteRepository extends Repository[Site] {}

object SiteRepository {
  def apply: SiteRepository = new SiteRepositoryImpl()
}
