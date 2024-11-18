    package com.sqc.academy.dto;

    import com.fasterxml.jackson.annotation.JsonInclude;
    import lombok.*;
    import lombok.experimental.FieldDefaults;

    @Getter
    @Setter
    @FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL) // không trả về giá trị null
   // T : truyền kiểu DL kiểu tham số
    // VD: ApiResponse<Student> : truyền kiểu DL là Student
    public class ApiResponse<T> {
    Integer code;
    String message;
    T data;

    }
