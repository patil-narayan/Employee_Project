package com.example.EmployeeManagement.exceptionhandler;

import com.example.EmployeeManagement.exception.EmployeeManagementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class EmployeeManagementExceptionHandler {

    @ExceptionHandler(EmployeeManagementException.class)
    public ProblemDetail userManagementExceptionHandler(EmployeeManagementException exception) {
        log.error("UserManagementException Handled: Requested by {} error {} is caused by {} ", exception.getUserId(), exception.getErrorMsg(), exception.getCause(),
                exception);
        var detail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return detail;
    }
}
