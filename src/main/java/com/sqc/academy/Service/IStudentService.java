package com.sqc.academy.Service;

import com.sqc.academy.Model.Student;

import java.util.List;

public interface IStudentService {
 List<Student> findAll();
    Student findById(Integer id);
    Student save(Student student);


}
