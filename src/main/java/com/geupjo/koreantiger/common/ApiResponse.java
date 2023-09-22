package com.geupjo.koreantiger.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.geupjo.koreantiger.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private static final String SUCCESS = "Success";
    private static final String FAILED = "Failed";
    private static final String ERROR = "요청하신 API가 올바르지 않습니다.";

    private String status;
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS, data);
    }

    public static ApiResponse<Void> noContent() {
        return new ApiResponse<>(SUCCESS, null);
    }

    public static ApiResponse<?> createFail(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            if (error instanceof FieldError) {
                errors.put(((FieldError) error).getField(), error.getDefaultMessage());
            } else {
                errors.put(error.getObjectName(), error.getDefaultMessage());
            }
        }
        return new ApiResponse<>(FAILED, errors);
    }

    public static ApiResponse<?> createError(ErrorCode errorCode) {
        return new ApiResponse<>(ERROR, errorCode.getMessage());
    }
}
