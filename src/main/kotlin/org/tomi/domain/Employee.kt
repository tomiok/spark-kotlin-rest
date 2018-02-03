package org.tomi.domain

import com.google.gson.Gson

class Employee(val hoursPerDay: Int, var name: String) {

  var id: String = ""

  var salaryPerDay: Double = 0.0

  var department: Department? = null

  var type: EmployeeType? = null

  fun toJson(): String {
    return Gson().toJson(this)
  }

  enum class EmployeeType {
    JUNIOR,
    SEMI_SENIOR,
    SENIOR,
    SPECIALIST
  }
}