package com.sqc.academy.Respository;

import com.sqc.academy.Model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();

    Student findById(Integer id);
    Student save(Student student);

}
