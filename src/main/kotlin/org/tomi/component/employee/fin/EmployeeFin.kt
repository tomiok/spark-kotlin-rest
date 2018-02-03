package org.tomi.component.employee.fin

import org.tomi.domain.Employee
import java.time.Month

interface EmployeeFin {

  fun calculatePay(employee: Employee, days: Int): Double

  fun reportHours(employee: Employee, month: Month): Int

  fun save(employee: Employee)
}