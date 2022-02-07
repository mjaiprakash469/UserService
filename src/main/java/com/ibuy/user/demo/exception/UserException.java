package com.ibuy.user.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import com.ibuy.user.demo.dto.ErrorResponse;
import com.ibuy.user.demo.exception.InvalidUserCredentials;

@ControllerAdvice
public class UserException extends ResponseEntityExceptionHandler {
	private final Logger logger = LogManager.getLogger(UserException.class);
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(InvalidUserCredentials.class)
	public ResponseEntity<ErrorResponse> handleExceptio(InvalidUserCredentials ex){
		ErrorResponse validationErrorResponse = new ErrorResponse();
		validationErrorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		validationErrorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(validationErrorResponse,HttpStatus.UNAUTHORIZED);
	}
}
