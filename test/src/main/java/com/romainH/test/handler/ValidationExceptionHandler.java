package com.romainH.test.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException exception) {
	Map<String, String> errors = new HashMap<>();
	exception.getBindingResult().getFieldErrors()
		.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	return ResponseEntity.badRequest().body(errors);
    }

}
