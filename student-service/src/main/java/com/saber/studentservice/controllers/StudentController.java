package com.saber.studentservice.controllers;

import com.saber.studentservice.dto.StudentModel;
import com.saber.studentservice.entity.Student;
import com.saber.studentservice.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${service.api.base-path}")
@Slf4j
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentModel studentModel){
        log.info("Request for add Student with Body ===> {}",studentModel);
        Student student=this.studentService.addStudent(studentModel);
        log.info("Response for add Student  ===> {}",student);
        return ResponseEntity.ok(student);
    }
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> studentList = this.studentService.findAllStudent();
        return ResponseEntity.ok(studentList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable(name = "id") Integer id){
        log.info("Request for find Student By Id ===> {}",id);
        Student student = this.studentService.findById(id);
        if (student==null){
            log.error("Student not found ");
            return ResponseEntity.notFound().build();
        }
        log.info("Response for find Student  ===> {}",student);
        return ResponseEntity.ok(student);
    }
}
