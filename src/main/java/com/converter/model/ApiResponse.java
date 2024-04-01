package com.converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse {

    // other values
    private ApiError error;

    public ApiResponse(ApiError apiError) {
        this.error = apiError;
    }

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}
    
    
}