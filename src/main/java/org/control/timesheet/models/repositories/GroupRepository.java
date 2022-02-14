package org.control.timesheet.models.repositories;

import org.control.timesheet.models.core.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
}
