package com.epam.training.currencyConverter.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@ControllerAdvice
public class DefaultControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultControllerAdvice.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        String errorMessage = "Target currency is not available: " + request.getParameter("targetCurrency");
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalException(IllegalArgumentException ex, WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        String msg = request.getParameterMap().entrySet()
                .stream().map(entry -> entry.getKey() + " : " + Optional.of(entry.getValue()).map(array -> array[0]).get())
                .collect(Collectors.joining(", "));
        return handleExceptionInternal(ex, "Invalid input parameter(s): " + msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        return handleExceptionInternal(ex, "Internal server error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
