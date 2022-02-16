package org.control.timesheet.services;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PositionService {
    @Autowired
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position create(Position position) {
        this.positionRepository.save(position);
        return position;
    }

    public Position update(Integer id, Position position) {
        Position storedModel = this.findById(id);

        storedModel.setName(position.getName());
        storedModel.setIsActive(position.getIsActive());

        positionRepository.save(storedModel);

        return storedModel;
    }

    public Iterable<Position> findAll() {
        return this.positionRepository.findAll();
    }

    public Position findById(Integer id) {
        return this.positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found position by id = " + id));
    }
}
