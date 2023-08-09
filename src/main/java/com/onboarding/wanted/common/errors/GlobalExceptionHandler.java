package com.onboarding.wanted.common.errors;

import com.onboarding.wanted.common.errors.exception.BusinessException;
import com.onboarding.wanted.common.util.ApiResult;
import com.onboarding.wanted.common.util.ResponseGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@Slf4j
public class GlobalExceptionHandler {
    /**
     * javax.validation.Valid 또는 @Validated binding error가 발생할 경우
     */
    @ExceptionHandler(BindException.class)
    protected ApiResult handleBindException(BindException e) {
        log.error("handleBindException", e);
        return ResponseGenerator.fail(e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ApiResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);
        return ResponseGenerator.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    /**
     * 비즈니스 로직 실행 중 오류 발생
     */
    @ExceptionHandler(value = {BusinessException.class})
    protected ApiResult handleConflict(BusinessException e) {
        log.error("BusinessException", e);
        return ResponseGenerator.fail(e.getErrorCode().getStatus(), e.getErrorCode().getMessage());
    }

    /**
     * 나머지 예외 발생
     */
    @ExceptionHandler(Exception.class)
    protected ApiResult handleException(Exception e) {
        log.error("Exception", e);
        return ResponseGenerator.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
