package com.sqc.academy.Service.impl;

import com.sqc.academy.Model.Student;
import com.sqc.academy.Respository.IStudentRepository;
import com.sqc.academy.Respository.impl.StudentRepository;
import com.sqc.academy.Service.IStudentService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class StudentService  implements IStudentService {
    IStudentRepository studentRepository ;
@Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
@Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);

    }
@Override
    public Student save(Student student) {
        return studentRepository.save(student);

    }
}