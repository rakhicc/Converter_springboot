package com.converter.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.converter.model.ApiResponse;
import com.converter.util.ApiResponseUtil;

@ControllerAdvice
public class ConverterExceptionHandler {

	
	    @ResponseBody
	    @ExceptionHandler(InternalException.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ApiResponse internalServerErrorHandler(InternalException ex) {
	        return ApiResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	    }
	    
	    @ResponseBody
	    @ExceptionHandler(BadRequestException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ApiResponse BadRequestHandler(BadRequestException ex) {
	        return ApiResponseUtil.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	    }
}
