package org.timesheet.humanresourcesdepartment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timesheet.humanresourcesdepartment.models.core.Employee;
import org.timesheet.humanresourcesdepartment.models.core.Group;
import org.timesheet.humanresourcesdepartment.models.core.Position;
import org.timesheet.humanresourcesdepartment.models.repositories.EmployeeRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/index")
    public Iterable<Employee> index() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public Employee add(@Valid @ModelAttribute Employee employee) {
        Group group = employee.getGroup();
        Position position = employee.getPosition();
        employee.setGroup(group);
        employee.setPosition(position);
        employeeRepository.save(employee);
        return employee;
    }

    @PostMapping("/update/{id}")
    public Employee update(@PathVariable Integer id, @Valid @ModelAttribute Employee employee) {
        Employee storedEmployee = this.findById(id);
        Group group = employee.getGroup();
        Position position = employee.getPosition();

        storedEmployee.setName(employee.getName());
        storedEmployee.setSurname(employee.getSurname());
        storedEmployee.setPatronymic(employee.getPatronymic());
        storedEmployee.setIsActive(employee.getIsActive());
        storedEmployee.setHiringAt(employee.getHiringAt());
        storedEmployee.setDismissalAt(employee.getDismissalAt());
        storedEmployee.setGroup(group);
        storedEmployee.setPosition(position);

        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/view/{id}")
    public Employee view(@PathVariable Integer id) {
        return this.findById(id);
    }

    private Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found by id " + id));
    }
}
