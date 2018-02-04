package org.tomi.component.employee.fin

import org.tomi.domain.Employee

class PayCalculator {

  fun calculatePay(employee: Employee, days: Int): Double {
    return employee.hoursPerDay * employee.salaryPerDay * days
  }
}