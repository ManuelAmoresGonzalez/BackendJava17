package com.manuelamores.exceptions;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {


    //This function is for springboot 3 and above
    @ExceptionHandler(ModelNotFoundExceptions.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundExceptions e, WebRequest request){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Model Not Found");
        problemDetail.setType(URI.create(request.getContextPath()));
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperty("Valor 1 ", "valor1");
        problemDetail.setProperty("Valor 2 ", true);
        problemDetail.setProperty("Valor  ", 36);
        return problemDetail;
    }

    //This feature is for Springboot 2 and below.
    /*@ExceptionHandler(ModelNotFoundExceptions.class)
    public ResponseEntity<CustomErrorReport> handleModelNotfoundException(ModelNotFoundExceptions ex, WebRequest request){
        CustomErrorReport errorResponse = new CustomErrorReport (LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }*/

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<CustomErrorReport> handleArithmeticException(ArithmeticException e, WebRequest request){
        CustomErrorReport errorResponse = new CustomErrorReport(
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String message = ex.getBindingResult().getFieldErrors().stream().map(error ->
             error.getField() + " : " + error.getDefaultMessage()
        ).collect(Collectors.joining(", "));

        CustomErrorReport errorResponse = new CustomErrorReport(
                LocalDateTime.now(),
                message,
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
