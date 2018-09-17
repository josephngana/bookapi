package repository.systemlogs

import domain.systemlogs.SystemLogEvents
import repository.Repository
import repository.systemlogs.Impl.cassandra.SystemLogEventsRepositoryImpl

import scala.concurrent.Future

trait SystemLogEventsRepository extends Repository[SystemLogEvents]{
  def getSiteLogEvents(siteId:String): Future[Seq[SystemLogEvents]]

}

object SystemLogEventsRepository {
  def apply: SystemLogEventsRepository = new SystemLogEventsRepositoryImpl()
}
