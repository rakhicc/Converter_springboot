package com.converter.util;

import com.converter.model.ApiError;
import com.converter.model.ApiResponse;

public class ApiResponseUtil {
    public static ApiResponse error(int value, String message) {
        return new ApiResponse(new ApiError(value, message));
    }
}