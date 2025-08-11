package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.mapper.AddressMapper;
import com.developer.coder.sms.mapper.StudentMapper;
import com.developer.coder.sms.repository.StudentInterface;
import com.developer.coder.sms.service.Studentservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements Studentservice {  // ✅ FIXED — implements the correct interface

    private final StudentInterface studentRepository;

    public StudentServiceImpl(StudentInterface studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Studentdto createStudent(Studentdto studentdto) {
        Student student = StudentMapper.mapToStudent(studentdto);
        Student saved = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    @Override
    public List<Studentdto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
    }

    @Override
    public Studentdto getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public Studentdto updateStudent(Integer id, Studentdto studentdto) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        existing.setName(studentdto.getName());
        existing.setRollNumber(studentdto.getRollNo());
        existing.setClassName(studentdto.getClassname());

        existing.getAddresses().clear();
        if (studentdto.getAddresses() != null) {
            studentdto.getAddresses().forEach(addr -> existing.addAddress(AddressMapper.mapToAddress(addr)));
        }

        Student updated = studentRepository.save(existing);
        return StudentMapper.mapToStudentDto(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        studentRepository.delete(student);
    }

    @Override
    public List<Addressdto> getAddressesByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));
        return student.getAddresses().stream().map(AddressMapper::mapToAddressDto).toList();
    }

    @Override
    public Studentdto updateAddress(int studentId, Addressdto addressDto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));
        student.addAddress(AddressMapper.mapToAddress(addressDto));
        Student saved = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }
}
