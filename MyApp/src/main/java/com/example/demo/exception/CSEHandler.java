package com.example.demo.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ErrorRespDTO;

@ControllerAdvice
public class CSEHandler {
	
	@ExceptionHandler(value=CountryServiceException.class)
	public ResponseEntity<Object> handleCSE(CountryServiceException ex){
		ErrorRespDTO errdto = new ErrorRespDTO(Arrays.asList(ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errdto,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value=ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e){
		List<String> errs = new ArrayList<>();
		e.getConstraintViolations().stream().forEach(r -> {
			errs.add(r.getMessage());
		});
		ErrorRespDTO errdto = new ErrorRespDTO(errs,HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errdto,HttpStatus.BAD_REQUEST);
	}
}
