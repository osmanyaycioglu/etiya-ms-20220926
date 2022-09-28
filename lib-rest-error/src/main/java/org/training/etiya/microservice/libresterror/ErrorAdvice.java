package org.training.etiya.microservice.libresterror;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice()
public class ErrorAdvice {

    @Value("${spring.application.name}")
    private String msName;

    public ErrorObj createBaseError() {
        return new ErrorObj().setService(msName);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(MethodArgumentNotValidException exception) {
        ErrorObj root = createBaseError().setDesc("Validasyon problemi")
                                         .setErrorCode(1048);
        List<ObjectError> allErrors = exception.getAllErrors();
        for (ObjectError objectError : allErrors) {
            root.add(createBaseError().setErrorCode(1049)
                                      .setDesc(objectError.toString()));
        }
        return root;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(ConstraintViolationException exception) {
        ErrorObj root = createBaseError().setDesc("Validasyon problemi")
                                         .setErrorCode(1048);
        Set<ConstraintViolation<?>> allErrors = exception.getConstraintViolations();
        for (ConstraintViolation<?> objectError : allErrors) {
            root.add(createBaseError().setErrorCode(1049)
                                      .setDesc(objectError.toString()));
        }
        return root;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exception) {
        return createBaseError().setErrorCode(1048)
                                .setDesc("Validasyon problemi : " + exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(Exception exception) {
        exception.printStackTrace();
        if (exception instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body(createBaseError().setErrorCode(5001)
                                                        .setDesc("Null error : " + exception.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(createBaseError().setErrorCode(5000)
                                                    .setDesc("Internal error : " + exception.getMessage()));
    }

}
