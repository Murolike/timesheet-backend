package org.timesheet.humanresourcesdepartment.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.timesheet.humanresourcesdepartment.models.core.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {
}
