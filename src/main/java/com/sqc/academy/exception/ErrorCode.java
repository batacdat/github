package com.sqc.academy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public enum ErrorCode {

    STUDENT_NOT_EXITS(40401, "Student not exits", HttpStatus.NOT_FOUND),;
    Integer code;
    String message;
    HttpStatus status;


}
