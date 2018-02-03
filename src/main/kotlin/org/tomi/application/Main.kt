package org.tomi.application

import org.tomi.component.employee.fin.EmployeeFinImpl
import org.tomi.domain.Department
import org.tomi.domain.Employee
import spark.Spark.get
import spark.Spark.path
import spark.Spark.post
import java.time.Month
import java.util.UUID

private val employeeFinImpl = EmployeeFinImpl();

private val employee = Employee(8, "Sir Lancelot")

fun main(args: Array<String>) {

  val log = org.slf4j.LoggerFactory.getLogger("main class")

  employee.department = Department("Management")
  employee.type = Employee.EmployeeType.SENIOR
  employee.salaryPerDay = 45.00

  path("/employees") {

    get("/hours/:month") { request, response ->
      employeeFinImpl.reportHours(employee, Month.of(request.params("month").toInt()))

    }

    get("/calculate/:days") { request, response ->
      employeeFinImpl.calculatePay(employee, request.params("days").toInt()) // number of days worked in the month
    }

    post("/save") { request, response ->

      log.info("Saving employee...")
      employee.id = UUID.randomUUID().toString()
      employeeFinImpl.save(employee)

      response.status(201)
      response.type("application/json")
      employee.toJson()
    }
  }
}
