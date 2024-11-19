package com.sqc.academy.Respository.impl;

import com.sqc.academy.Model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sqc.academy.Respository.IStudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements IStudentRepository {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Hồ Văn Trung", 9.6),
            new Student(2, "Ngọc Mai", 9.8),
            new Student(3, "Phương", 9.7)
    ));


    public List<Student> findAll() {
        return students;
    }

    public Student findById(Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public Student save(Student student){
        student.setId((int) (Math.random() * 100000000));
        students.add(student);
        return student;
    }




}
