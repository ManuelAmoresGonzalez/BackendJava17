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


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorReport> handleAllException(Exception ex, WebRequest req){
        CustomErrorReport errorResponse = new CustomErrorReport(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundExceptions.class)
    public ResponseEntity<CustomErrorReport> handleModelNotFoundException(ModelNotFoundExceptions ex, WebRequest req){
        CustomErrorReport errorResponse = new CustomErrorReport(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Desde Spring Boot 3
    /*@ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException ex, WebRequest req){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pd.setTitle("Model Not Found Exception");
        pd.setType(URI.create(req.getContextPath()));
        pd.setProperty("var1", "value1");
        pd.setProperty("var2", true);
        pd.setProperty("var3", 32);
        return pd;
    }*/

    @ExceptionHandler({ArithmeticException.class, IndexOutOfBoundsException.class})
    public ResponseEntity<CustomErrorReport> handleArithmeticException(ArithmeticException ex, WebRequest req){
        CustomErrorReport errorResponse = new CustomErrorReport(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorReport> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest req){
        CustomErrorReport errorResponse = new CustomErrorReport(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }*/

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {

        String message = ex.getBindingResult().getFieldErrors().stream()
                .map( error -> error.getField() + " : " + error.getDefaultMessage())
                .collect(Collectors.joining(","));

        /*String message = "";
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            message += error.getField() + " : " + error.getDefaultMessage() + ", ";
        }*/

        CustomErrorReport errorResponse = new CustomErrorReport(LocalDateTime.now(), message, req.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
