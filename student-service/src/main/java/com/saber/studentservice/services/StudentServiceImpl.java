package com.saber.studentservice.services;

import com.saber.studentservice.dto.StudentModel;
import com.saber.studentservice.entity.Student;
import com.saber.studentservice.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Student addStudent(StudentModel studentDto) {
        Student student=new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        return this.studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Integer id) {
        return this.studentRepository.findById(id).orElseGet(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudent() {
        return this.studentRepository.findAll();
    }
}
