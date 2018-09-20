package services.systemlogs

import domain.systemlogs.SystemLogEvents
import services.CrudService
import services.systemlogs.Impl.SystemLogEventsServiceImpl

import scala.concurrent.Future

trait SystemLogEventsService extends CrudService[SystemLogEvents]{
  def getSiteLogEvents(siteId: String): Future[Seq[SystemLogEvents]]

}

object SystemLogEventsService{
  def apply: SystemLogEventsService = new SystemLogEventsServiceImpl()
}
