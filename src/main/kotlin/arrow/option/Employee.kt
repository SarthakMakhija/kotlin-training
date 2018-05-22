package arrow.option

import arrow.core.*

class Employee(val name: String) {
    private var department: Option<Department> = None

    constructor(name: String, department: Department) : this(name) {
        this.department = Some(department)
    }

    fun departmentName() = department.map { it.name.toUpperCase() }.getOrElse { "UNASSIGNED" }
}

class Department(val name: String)