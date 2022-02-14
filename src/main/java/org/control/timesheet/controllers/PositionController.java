package org.control.timesheet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.PositionRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/index")
    public Iterable<Position> index() {
        return positionRepository.findAll();
    }

    @PostMapping("/add")
    public Position add(@Valid @ModelAttribute Position position) {
        return positionRepository.save(position);
    }

    @PostMapping("/update/{id}")
    public Position update(@PathVariable Integer id, @Valid @ModelAttribute @NotNull Position position) {
        Position storedPosition = this.findById(id);

        storedPosition.setName(position.getName());
        storedPosition.setIsActive(position.getIsActive());

        positionRepository.save(storedPosition);

        return storedPosition;
    }

    @GetMapping("/view/{id}")
    public Position view(@PathVariable Integer id) {
        return findById(id);
    }

    protected Position findById(Integer id) {
        return positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found by id " + id));
    }
}
