package org.timesheet.humanresourcesdepartment.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.timesheet.humanresourcesdepartment.models.core.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
