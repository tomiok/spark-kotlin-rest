package org.tomi.component.employee.fin

import org.tomi.domain.Employee

class EmployeeRepository {

  fun save(employee: Employee) {
    println("Saving employee: " + employee.id + ", " + employee.name)
  }
}