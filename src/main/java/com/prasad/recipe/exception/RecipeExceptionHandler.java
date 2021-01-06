package com.prasad.recipe.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(basePackages =  "com.prasad.recipe")
public class RecipeExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(RecipeExceptionHandler.class);

	/**
	 * Resource not found exception.
	 *
	 * @param exception      
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(RecipeNotFoundException exception, WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}


	
	/**
	 * All other excpetion handler.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> recipeExcpetionHandler(Exception exception, WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleConstraintViolationException(ConstraintViolationException exception,
			WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}
}
