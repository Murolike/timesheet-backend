package org.control.timesheet.services;

import org.control.timesheet.models.core.Employee;
import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void create(Employee employee) {
        Position position = employee.getPosition();
        Group group = employee.getGroup();

        employee.setPosition(position);
        employee.setGroup(group);
        this.employeeRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
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
    }

    public Employee findById(Integer id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Employee by id " + id));
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
