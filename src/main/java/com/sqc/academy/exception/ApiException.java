package com.sqc.academy.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ApiException extends RuntimeException {
    ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }




}
