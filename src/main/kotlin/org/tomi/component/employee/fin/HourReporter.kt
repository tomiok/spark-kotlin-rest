package org.tomi.component.employee.fin

import org.tomi.domain.Employee
import java.time.Month

class HourReporter {

  fun reportHours(employee: Employee, month: Month): Int {
    return employee.hoursPerDay * month.length(false)
  }
}