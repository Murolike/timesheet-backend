package org.control.timesheet.services;

import org.control.timesheet.models.core.Employee;
import org.control.timesheet.models.core.Group;
import org.control.timesheet.models.core.Position;
import org.control.timesheet.models.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        Position position = employee.getPosition();
        Group group = employee.getGroup();

        employee.setPosition(position);
        employee.setGroup(group);

        return this.employeeRepository.save(employee);
    }

    public Employee update(Integer id, Employee employee) {
        Employee storedModel = this.findById(id);
        Group group = employee.getGroup();
        Position position = employee.getPosition();

        Calendar calendar = new GregorianCalendar();
        Timestamp updatedAt = new Timestamp(calendar.getTimeInMillis()); // can be method in this class

        storedModel.setUpdatedAt(updatedAt);
        storedModel.setName(employee.getName());
        storedModel.setSurname(employee.getSurname());
        storedModel.setPatronymic(employee.getPatronymic());
        storedModel.setIsActive(employee.getIsActive());
        storedModel.setHiringAt(employee.getHiringAt());
        storedModel.setDismissalAt(employee.getDismissalAt());
        storedModel.setGroup(group);
        storedModel.setPosition(position);

        return employeeRepository.save(storedModel);
    }

    public Employee findById(Integer id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Employee by id " + id));
    }

    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
