package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.service.Studentservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private Studentservice  studentService;
    //build add student id rest api
    @PostMapping("/")
    public ResponseEntity<Studentdto> createStudent(@Valid @RequestBody Studentdto studentdto){
       Studentdto savedstudent=studentService.createStudent(studentdto);
       return new ResponseEntity<>(savedstudent, HttpStatus.CREATED);
    }

    //@GetMapping("/")
    //public String helloWorld(){
       // return "Hello World";
    //}
    @GetMapping("/")
    public ResponseEntity<List<Studentdto>> getAllStudents() {
        List<Studentdto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@Valid @PathVariable Integer id, @RequestBody Studentdto studentdto) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
