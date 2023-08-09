package com.onboarding.wanted.common.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@UtilityClass
public class ResponseGenerator {
    public static <T> ApiResult<ResponseBody.SuccessBody<T>> success(final T data,
                                                                     final HttpStatus status) {
        return new ApiResult<>(new ResponseBody.SuccessBody<>(data, String.valueOf(status)), status);
    }

    public static ApiResult<ResponseBody.SuccessBodyWithoutData> success(final HttpStatus status) {
        return new ApiResult<>(new ResponseBody.SuccessBodyWithoutData(String.valueOf(status)), status);
    }

    public static ApiResult<ResponseBody.FailBody> fail(final HttpStatus status,
                                                        final String message) {
        return new ApiResult<>(new ResponseBody.FailBody(String.valueOf(status), message), status);
    }

    public static ApiResult<ResponseBody.FailBody> fail(final BindingResult bindingResult,
                                                        final HttpStatus status) {
        return new ApiResult<>(new ResponseBody.FailBody(String.valueOf(status), bindingResult), status);
    }
}
