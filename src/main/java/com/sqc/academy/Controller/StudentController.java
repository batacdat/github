package com.sqc.academy.Controller;

import com.sqc.academy.Model.Student;
import com.sqc.academy.Service.IStudentService;
import com.sqc.academy.Service.impl.StudentService;
import com.sqc.academy.dto.ApiResponse;
import com.sqc.academy.exception.ApiException;
import com.sqc.academy.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor  //DI
@RestController
@FieldDefaults(makeFinal = true,level = lombok.AccessLevel.PRIVATE)
@RequestMapping("/students")
public class StudentController {
//  IStudentService studentService = new StudentService();


       IStudentService studentService;   //-->tiem thong qua Constructor



    //@RequestMapping(value="/students", method= RequestMethod.GET)
    //lấy tất cả các GT của tất cả phương thức (GET, POST, PUT, DELETE)
    @GetMapping
    //chỉ cho phép sử dụng phương thức GET để lấy GT
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

//reponseEntity : trả về status của đối tượng
// ( VD: nếu tìm tìm thấy DT thì trả về status 200, còn không thì trả về status 404)
    @RequestMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getByIdStudents(@PathVariable int id) {
// theo mô hình MVC :
        // nếu mà tìm thấy thì trả về status 200 và GT của đối tượng
        // còn không thì trả về status 404
        Student student = studentService.findById(id);
        if(student != null){
            return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
        }

//
//        for (Student student : studentService.findAll()) {
//            if (student.getId() == id) {
//              //  return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
//                return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());
//            }
//        }
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


   //bài 1+2
        //        student.setId((int) (Math.random() * 100000000));
//        studentService.findAll().add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Student>builder().data(studentService.save( student)).build());
    }














}