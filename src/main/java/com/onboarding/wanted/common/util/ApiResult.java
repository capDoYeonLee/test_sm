package com.onboarding.wanted.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResult<T> extends ResponseEntity<T> {
    public ApiResult(T body, HttpStatus status){
        super(body, status);
    }
}
