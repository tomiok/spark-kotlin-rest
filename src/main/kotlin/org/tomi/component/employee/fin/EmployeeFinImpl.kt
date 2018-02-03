package org.tomi.component.employee.fin

import org.tomi.domain.Employee
import java.time.Month

class EmployeeFinImpl : EmployeeFin {

  private val payCalculator = PayCalculator()

  private val hourReporter = HourReporter()

  private val employeeRepo = EmployeeRepository()

  override fun calculatePay(employee: Employee, days: Int): Double {
    return payCalculator.calculatePay(employee, days)
  }

  override fun reportHours(employee: Employee, month: Month): Int {
    return hourReporter.reportHours(employee, month)
  }

  override fun save(employee: Employee) {
    employeeRepo.save(employee)
  }
}