package com.example.menuitem.exception;


import java.io.IOException;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomErrorController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MenuItemNotFoundException.class) 
	public void  springHandleMenuItemNotFound(HttpServletResponse response) throws IOException {
		  response.sendError(HttpStatus.BAD_REQUEST.value()," MenuItemId is not found"); 
		}
	
	@ExceptionHandler(ListEmptyException.class) 
	public void  springHandleListEmpty(HttpServletResponse response) throws IOException {
		  response.sendError(HttpStatus.BAD_REQUEST.value(), "There is no MenuItem...."); 
		}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
	}

}
