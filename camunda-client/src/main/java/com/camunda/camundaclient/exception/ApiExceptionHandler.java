package com.mandat.affecationf.exception;

import com.mandat.affecationf.model.ErrorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
    /**
     * BAD REQUEST 400
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("BAD REQUEST BindException",ex);
        List<ErrorDetails> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    ErrorDetails errorDetails = new ErrorDetails();
                    errorDetails.setCode(status.value());
                    errorDetails.setMessage(fieldError.getDefaultMessage());
                    errorDetails.setField(fieldError.getField());
                    errorDetails.setValue(fieldError.getRejectedValue());
                    errorDetails.setLocation(ErrorDetails.LocationEnum.BODY);
                    return errorDetails;
                }).collect(Collectors.toList());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     * Error Exception BAD REQUEST
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("BAD REQUEST MessageNotReadableException", ex);
        ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setCode(status.value());
            errorDetails.setMessage(ex.getMessage());
        errorDetails.setLocation(ErrorDetails.LocationEnum.BODY);
        return new ResponseEntity<>(errorDetails,status);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }

    /**
     * ALL OTHER ERROR EXCEPTION 500
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
        logger.error("error technique 500", exception);
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setLocation(ErrorDetails.LocationEnum.BODY);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
