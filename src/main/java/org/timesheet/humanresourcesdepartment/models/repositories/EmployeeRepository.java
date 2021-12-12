package org.timesheet.humanresourcesdepartment.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.timesheet.humanresourcesdepartment.models.core.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
