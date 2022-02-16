package org.control.timesheet.controllers;

import org.control.timesheet.models.core.Employee;
import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.EmployeeRepository;
import org.control.timesheet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/index")
    public Iterable<Employee> index() {
        return this.employeeService.findAll();
    }

    @PostMapping("/add")
    public Employee add(@Valid @ModelAttribute Employee employee) {
        return this.employeeService.create(employee);
    }

    @PostMapping("/update/{id}")
    public Employee update(@PathVariable Integer id, @Valid @ModelAttribute Employee employee) {
        return this.employeeService.update(id, employee);
    }

    @GetMapping("/view/{id}")
    public Employee view(@PathVariable Integer id) {
        return this.employeeService.findById(id);
    }
}
