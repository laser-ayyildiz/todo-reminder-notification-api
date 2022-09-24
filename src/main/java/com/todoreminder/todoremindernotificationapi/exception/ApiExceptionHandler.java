package com.todoreminder.todoremindernotificationapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleServiceException(HttpServletRequest request, ServiceException ex) {
        log.warn("Exception thrown and handled by advice. Exception details: ", ex);
        return new ResponseEntity<>(ErrorResponse.from(request, ex.getError()), new HttpHeaders(),
                ex.getError().getHttpStatus());
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers, @NotNull HttpStatus status,
                                                                  @NotNull WebRequest request) {
        log.warn("Exception thrown and handled by advice. Exception details: ", ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .errors(ex.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()))
                .path(((ServletWebRequest) request).getRequest().getRequestURI()).build();
        return new ResponseEntity<>(errorResponse, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        log.warn("Exception thrown and handled by advice. Exception details: ", ex);
        ConstraintViolation<?> violation = ex.getConstraintViolations().stream().findFirst().orElse(null);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .errors(Collections.singletonList(violation != null ? violation.getMessage() : null))
                .path(((ServletWebRequest) request).getRequest().getRequestURI()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(HttpServletRequest request, Exception ex) {
        log.error("Exception thrown and handled by advice. Exception detail: ", ex);
        return new ResponseEntity<>(ErrorResponse.from(request, GlobalError.INTERNAL_SERVER_ERROR), new HttpHeaders(),
                GlobalError.INTERNAL_SERVER_ERROR.getHttpStatus());
    }

}