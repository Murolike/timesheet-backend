package org.control.timesheet.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.control.timesheet.models.core.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {
}
