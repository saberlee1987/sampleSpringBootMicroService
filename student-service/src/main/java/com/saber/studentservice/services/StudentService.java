package com.saber.studentservice.services;

import com.saber.studentservice.dto.StudentModel;
import com.saber.studentservice.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(StudentModel studentDto);
    Student findById(Integer id);
    List<Student> findAllStudent();
}
