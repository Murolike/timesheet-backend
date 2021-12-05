package org.timesheet.humanresourcesdepartment.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.timesheet.humanresourcesdepartment.models.core.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {
}
