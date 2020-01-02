package com.chilltraders.core.exception;

public class ResourcelreadyExistsException extends ResourceNotFoundException {

	public ResourcelreadyExistsException(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName, fieldName, fieldValue);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
