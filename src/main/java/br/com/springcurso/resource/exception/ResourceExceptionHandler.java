package br.com.springcurso.resource.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.springcurso.exception.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiError> handleNotFoundException(NotFoundException ex){
		ApiError error = new ApiError();     //(, ex.getMessage(), new Date());
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setMsg(ex.getMessage());
		error.setDate(new Date());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
