package org.control.timesheet.services;

import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class PositionService {
    @Autowired
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position create(Position position) {
        return this.positionRepository.save(position);
    }

    public Position update(Integer id, Position position) {
        Position storedModel = this.findById(id);
        Calendar calendar = new GregorianCalendar();
        Timestamp updatedAt = new Timestamp(calendar.getTimeInMillis()); // can be method in this class

        storedModel.setUpdatedAt(updatedAt);
        storedModel.setName(position.getName());
        storedModel.setIsActive(position.getIsActive());

        return positionRepository.save(storedModel);
    }

    public Iterable<Position> findAll() {
        return this.positionRepository.findAll();
    }

    public Position findById(Integer id) {
        return this.positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found position by id = " + id));
    }
}
