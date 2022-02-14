package org.control.timesheet.models.repositories;

import org.control.timesheet.models.core.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
