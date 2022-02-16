package org.control.timesheet.controllers;

import org.control.timesheet.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.control.timesheet.models.core.Position;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/index")
    public Iterable<Position> index() {
        return this.positionService.findAll();
    }

    @PostMapping("/add")
    public Position add(@Valid @ModelAttribute Position position) {
        return this.positionService.create(position);
    }

    @PostMapping("/update/{id}")
    public Position update(@PathVariable Integer id, @Valid @ModelAttribute @NotNull Position position) {
        return this.positionService.update(id, position);
    }

    @GetMapping("/view/{id}")
    public Position view(@PathVariable Integer id) {
        return this.positionService.findById(id);
    }
}
