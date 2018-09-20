package services.systemlogs

import domain.systemlogs.SystemLogEvents
import services.CrudService
import services.systemlogs.Impl.SystemLogEventsServiceImpl

trait SystemLogEventsService extends CrudService[SystemLogEvents]{

}

object SystemLogEventsService{
  def apply: SystemLogEventsService = new SystemLogEventsServiceImpl()
}
