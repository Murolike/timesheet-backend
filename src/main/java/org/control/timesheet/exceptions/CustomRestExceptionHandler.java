package org.control.timesheet.exceptions;

import org.control.timesheet.api.DefaultApiErrorsFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.control.timesheet.api.ApiError;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        DefaultApiErrorsFormatter formatter = new DefaultApiErrorsFormatter(ex.getBindingResult());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), formatter.format());

        return new ResponseEntity<>(apiError, headers, apiError.getStatus());
    }
}
