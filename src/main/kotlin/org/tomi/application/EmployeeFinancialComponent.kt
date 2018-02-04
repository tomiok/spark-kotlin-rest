package org.tomi.application

import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import org.tomi.component.employee.fin.EmployeeFinImpl
import org.tomi.component.employee.fin.EmployeeRepository
import org.tomi.component.employee.fin.HourReporter
import org.tomi.component.employee.fin.PayCalculator
import org.tomi.domain.Employee
import java.time.Month

class EmployeeFinancialComponent : KoinComponent {

  private val employeeFin: EmployeeFinImpl by inject()

  fun reportHours(employee: Employee, month: Month): Int {
    return employeeFin.reportHours(employee, month)
  }

  fun save(employee: Employee) {
    return employeeFin.save(employee)
  }

  fun calculatePay(employee: Employee, days: Int): Double {
    return employeeFin.calculatePay(employee, days)
  }

  companion object {

    fun getFinModule(): Module {
      return module
    }
  }
}

val module: Module = applicationContext {
  provide { EmployeeFinImpl(PayCalculator(), HourReporter(), EmployeeRepository()) }
}