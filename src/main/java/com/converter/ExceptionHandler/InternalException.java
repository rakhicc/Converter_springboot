package com.converter.ExceptionHandler;

public class InternalException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalException(String message) {
        super(message);
    }
}