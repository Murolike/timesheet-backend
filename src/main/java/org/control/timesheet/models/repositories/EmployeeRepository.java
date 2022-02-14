package org.control.timesheet.models.repositories;

import org.control.timesheet.models.core.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
