package com.sqc.academy;

import com.sqc.academy.Student;
import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Hồ Văn Trung", 9.6),
            new Student(2, "Ngọc Mai", 9.8),
            new Student(3, "Phương", 9.7)
    ));


    //lấy tất cả các GT của tất cả phương thức (GET, POST, PUT, DELETE)
    //@RequestMapping(value="/students", method= RequestMethod.GET)
    @GetMapping
    //chỉ cho phép sử dụng phương thức GET để lấy GT
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

//reponseEntity : trả về status của đối tượng
// ( VD: nếu tìm tìm thấy DT thì trả về status 200, còn không thì trả về status 404)
    @RequestMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getByIdStudents(@PathVariable int id) {

        for (Student student : students) {
            if (student.getId() == id) {
              //  return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
                return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
            }
        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                ApiResponse.<Student>builder()
//                        .code(40401)
//                        .message("Not found")
//                        .build());
        //exception
        throw new ApiException(ErrorCode.STUDENT_NOT_EXITS);

//        return ResponseEntity.status(ErrorCode.STUDENT_NOT_EXITS.getStatus()).body(
//                ApiResponse.<Student>builder()
//                        .code(ErrorCode.STUDENT_NOT_EXITS.getCode())
//                        .message(ErrorCode.STUDENT_NOT_EXITS.getMessage())
//                        .build());
   }



// thêm mới :POST
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save( @RequestBody Student student) {
        student.setId((int) (Math.random() * 100000000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Student>builder().data(student).build());
    }














}