package com.sqc.academy.exception;

import com.sqc.academy.Student;
import com.sqc.academy.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // xử lý exception cho tất cả các controller
public class GlobalHendandleException {
@ExceptionHandler(ApiException.class) // xử lý exception ApiException
    public ResponseEntity<?> handleApiException(ApiException e){
       ErrorCode errorCode = e.getErrorCode();
    return ResponseEntity.status(errorCode.getStatus()).body(
            ApiResponse.builder()
                    .code(errorCode.getCode())
                    .message(errorCode.getMessage())
                    .build());
    }

}
