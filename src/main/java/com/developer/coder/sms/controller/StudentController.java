package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.service.Studentservice;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private Studentservice studentService;

    @PostMapping
    public ResponseEntity<Studentdto> createStudent(@Valid @RequestBody Studentdto studentdto) {
        log.info("Creating student: {}", studentdto);
        Studentdto createdStudent = studentService.createStudent(studentdto);
        log.info("Student created successfully with ID: {}", createdStudent.getId());
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/")
    public ResponseEntity<List<Studentdto>> getAllStudents() {
        log.info("Fetching all students");
        List<Studentdto> students = studentService.getAllStudents();
        log.info("Fetched {} students", students.size());
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable Integer id) {
        log.info("Fetching student with ID: {}", id);
        Studentdto student = studentService.getStudentById(id);
        log.info("Fetched student: {}", student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@Valid @PathVariable Integer id, @RequestBody Studentdto studentdto) {
        log.info("Updating student with ID: {}", id);
        Studentdto updatedStudent = studentService.updateStudent(id, studentdto);
        log.info("Student updated successfully: {}", updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        log.info("Deleting student with ID: {}", id);
        studentService.deleteStudent(id);
        log.info("Student deleted successfully with ID: {}", id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
