package org.control.timesheet.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class DefaultApiErrorsFormatter {

    private final BindingResult bindingResult;

    public DefaultApiErrorsFormatter(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public List<String> format() {
        List<String> errors = new ArrayList<>();

        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : bindingResult.getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return errors;
    }
}
