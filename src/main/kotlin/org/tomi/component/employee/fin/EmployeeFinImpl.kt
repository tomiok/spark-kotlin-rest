package org.tomi.component.employee.fin

import org.tomi.domain.Employee
import java.time.Month
import javax.ejb.Singleton

@Singleton
class EmployeeFinImpl(private var payCalc: PayCalculator,
  private var hourReporter: HourReporter,
  private var employeeRepo: EmployeeRepository) : EmployeeFin {

  override fun calculatePay(employee: Employee, days: Int): Double {
    return payCalc.calculatePay(employee, days)
  }

  override fun reportHours(employee: Employee, month: Month): Int {
    return hourReporter.reportHours(employee, month)
  }

  override fun save(employee: Employee) {
    employeeRepo.save(employee)
  }
}