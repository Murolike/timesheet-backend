package org.control.timesheet.services;

import org.control.timesheet.models.core.Employee;
import org.control.timesheet.models.core.Timesheet;
import org.control.timesheet.models.repositories.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class TimesheetService {
    @Autowired
    private final TimesheetRepository timesheetRepository;

    public TimesheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public Timesheet create(Timesheet timesheet) {
        this.timesheetRepository.save(timesheet);
        return timesheet;
    }

    public Timesheet update(Integer id, Timesheet timesheet) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Timesheet storedModel = this.findById(id);
        Employee employee = timesheet.getEmployee();

        storedModel.setMonth(timesheet.getMonth());
        storedModel.setYear(timesheet.getYear());
        storedModel.setEmployee(employee);

        String getterMethod = "getD";
        String setterMethod = "setD";

        for (int i = 1; i < 32; i++) {
            String fullGetterMethodName = getterMethod + ((i < 10) ? "0" + i : i);
            String fullSetterMethodName = setterMethod + ((i < 10) ? "0" + i : i);
            Method setter = storedModel.getClass().getMethod(fullSetterMethodName, Object.class);
            Method getter = timesheet.getClass().getMethod(fullGetterMethodName);

            setter.invoke(storedModel, getter.invoke(timesheet));
        }

        timesheetRepository.save(storedModel);
        return storedModel;
    }

    public Timesheet findById(Integer id) {
        return this.timesheetRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found timesheet by id = " + id));
    }

    public Iterable<Timesheet> findAll() {
        return this.timesheetRepository.findAll();
    }

    public Iterable<Timesheet> findByMonthAndYear(Integer month, Integer year) {
        return this.timesheetRepository.findByMonthAndYear(month, year);
    }
}
