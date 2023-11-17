package br.uff.lucasrogerio.desafiopickpaybackend.controller.handler;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.uff.lucasrogerio.desafiopickpaybackend.service.dto.ErrorResponseDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransactionSystemException.class)
    protected ResponseEntity<ErrorResponseDTO> handleConstraintViolationException(TransactionSystemException ex,
            ServletWebRequest request) {
        ErrorResponseDTO response;
        String errors;
        Throwable cause = ex.getRootCause();
        if (cause instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause)
                    .getConstraintViolations();
            errors = constraintViolations.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("; "));

        } else {
            errors = ex.getMessage();
        }
        response = new ErrorResponseDTO()
                .message(errors)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .path(request.getRequest().getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}