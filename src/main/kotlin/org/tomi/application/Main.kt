package org.tomi.application

import org.koin.standalone.StandAloneContext
import org.tomi.domain.Department
import org.tomi.domain.Employee
import spark.Spark.get
import spark.Spark.path
import spark.Spark.post
import java.time.Month
import java.util.UUID

private val employee = Employee(8, "Sir Lancelot")

fun main(args: Array<String>) {

  StandAloneContext.startKoin(listOf(EmployeeFinancialComponent.getFinModule()))

  val log = org.slf4j.LoggerFactory.getLogger("main class")

  val financialComponent = EmployeeFinancialComponent()

  employee.department = Department("Management")
  employee.type = Employee.EmployeeType.SENIOR
  employee.salaryPerDay = 45.00

  path("/employees") {

    get("/hours/:month") { request, response ->
      response.status(200)
      financialComponent.reportHours(employee, Month.of(request.params("month").toInt()))
    }

    get("/calculate/:days") { request, response ->
      financialComponent.calculatePay(employee, request.params("days").toInt()) // number of days worked in the month
    }

    post("/save") { request, response ->

      log.info("Saving employee...")
      employee.id = UUID.randomUUID().toString()
      financialComponent.save(employee)

      response.status(201)
      response.type("application/json")
      employee::toJson
    }
  }
}

