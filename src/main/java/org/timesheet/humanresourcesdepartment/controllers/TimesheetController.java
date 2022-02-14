package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timesheet.humanresourcesdepartment.models.core.Employee;
import org.timesheet.humanresourcesdepartment.models.core.Timesheet;
import org.timesheet.humanresourcesdepartment.models.repositories.TimesheetRepository;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @GetMapping("/index")
    public Iterable<Timesheet> index() {
        return timesheetRepository.findAll();
    }

    @PostMapping("/add")
    public Timesheet add(@Valid @ModelAttribute Timesheet timesheet) {
        Employee employee = timesheet.getEmployee();
        timesheet.setEmployee(employee);
        timesheetRepository.save(timesheet);
        return timesheet;
    }

    @PostMapping("/update/{id}")
    public Timesheet update(@PathVariable Integer id, @Valid @ModelAttribute Timesheet timesheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Timesheet storedModel = this.findById(id);
        Employee employee = timesheet.getEmployee();

        storedModel.setMonth(timesheet.getMonth());
        storedModel.setYear(timesheet.getYear());

        String getterMethod = "getD";
        String setterMethod = "setD";

        for (int i = 1; i < 32; i++) {
            String fullGetterMethodName = getterMethod + ((i < 10) ? "0" + i : i);
            String fullSetterMethodName = setterMethod + ((i < 10) ? "0" + i : i);
            Method setter = storedModel.getClass().getMethod(fullSetterMethodName, Object.class);
            Method getter = timesheet.getClass().getMethod(fullGetterMethodName);

            setter.invoke(storedModel, getter.invoke(timesheet));

        }

        storedModel.setEmployee(employee);

        timesheetRepository.save(storedModel);
        return storedModel;
    }

    @GetMapping("/view/{id}")
    public Timesheet view(@PathVariable Integer id) {
        return this.findById(id);
    }

    private Timesheet findById(Integer id) {
        return timesheetRepository.findById(id).orElseThrow(() -> new RuntimeException("Timesheet not found by id " + id));
    }
}
