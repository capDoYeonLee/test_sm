package com.onboarding.wanted.common.util;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.List;

public class ResponseBody {
    @Getter
    public static class SuccessBody<T> {
        private Timestamp timestamp;
        private String status;
        private T data;

        public SuccessBody(T data,String status) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.status = status;
            this.data = data;
        }
    }

    @Getter
    public static class SuccessBodyWithoutData<T> {
        private Timestamp timestamp;
        private String status;

        public SuccessBodyWithoutData(String status) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.status = status;
        }
    }

    @Getter
    public static class FailBody {
        private Timestamp timestamp;
        private String status;
        private String message;

        public FailBody(String status, String message) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.status = status;
            this.message = message;
        }

        public FailBody(String status, BindingResult bindingResult) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.status = status;
            this.message = createErrorMessage(bindingResult);
        }
    }

    private static String createErrorMessage(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if (!isFirst) {
                sb.append(", ");
            } else {
                isFirst = false;
            }
            sb.append("[");
            sb.append(fieldError.getField());
            sb.append("] ");
            sb.append(fieldError.getDefaultMessage());
        }

        return sb.toString();
    }
}
