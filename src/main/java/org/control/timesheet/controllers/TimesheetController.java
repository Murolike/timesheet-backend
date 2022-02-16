package org.control.timesheet.controllers;

import org.control.timesheet.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.control.timesheet.models.core.Timesheet;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/index")
    public Iterable<Timesheet> index() {
        return timesheetService.findAll();
    }

    @GetMapping("/get-all-by-year-and-month/{year}/{month}")
    public Iterable<Timesheet> getAllByYearAndMonth(@PathVariable Integer year, @PathVariable Integer month) {
        return this.timesheetService.findByMonthAndYear(month, year);
    }

    @PostMapping("/add")
    public Timesheet add(@Valid @ModelAttribute Timesheet timesheet) {
        return this.timesheetService.create(timesheet);
    }

    @PostMapping("/update/{id}")
    public Timesheet update(@PathVariable Integer id, @Valid @ModelAttribute Timesheet timesheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return this.timesheetService.update(id, timesheet);
    }

    @GetMapping("/view/{id}")
    public Timesheet view(@PathVariable Integer id) {
        return this.timesheetService.findById(id);
    }
}
