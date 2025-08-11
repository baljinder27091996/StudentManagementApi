package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.service.Studentservice;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final Studentservice studentService;

    public StudentController(Studentservice studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Studentdto> createStudent(@Valid @RequestBody Studentdto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Studentdto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studentdto> updateStudent(@PathVariable int id, @Valid @RequestBody Studentdto studentDto) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<List<Addressdto>> getAddressesByStudentId(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getAddressesByStudentId(id));
    }
}
