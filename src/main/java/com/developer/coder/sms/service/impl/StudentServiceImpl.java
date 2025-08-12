package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.entity.Student;
import com.developer.coder.sms.exception.DuplicateResourceException;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import com.developer.coder.sms.repository.AddressRepository;
import com.developer.coder.sms.repository.StudentInterface;
import com.developer.coder.sms.service.Studentservice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentServiceImpl implements Studentservice {

    private final StudentInterface studentRepo;
    private final AddressRepository addressRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentInterface studentRepo, AddressRepository addressRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Studentdto createStudent(Studentdto studentdto) {
        if (studentRepo.existsByRollNumber(studentdto.getRollNo())) {
            throw new DuplicateResourceException("Roll number already exists");
        }
        Student student = modelMapper.map(studentdto, Student.class);
        student = studentRepo.save(student);
        return modelMapper.map(student, Studentdto.class);
    }
    @Override
    public Studentdto createStudentifEXCEPTION(Studentdto studentdto) {
        try {
            return createStudent(studentdto);
        } catch (Exception e) {
            throw new RuntimeException("Error creating student: " + e.getMessage());
        }
    }

    @Override
    public List<Studentdto> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(student -> modelMapper.map(student, Studentdto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Studentdto getStudentById(Integer id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        return modelMapper.map(student, Studentdto.class);
    }

    @Override
    public Studentdto updateStudent(Integer id, Studentdto studentdto) {
        Student existing = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        existing.setName(studentdto.getName());
        existing.setRollNumber(studentdto.getRollNo());
        existing.setClassName(studentdto.getClassname());

        if (studentdto.getAddress() != null) {
            Address address = modelMapper.map(studentdto.getAddress(), Address.class);
            existing.setAddress(address);
        }

        Student updated = studentRepo.save(existing);
        return modelMapper.map(updated, Studentdto.class);
    }

    @Override
    public void deleteStudent(Integer id) {
        if (!studentRepo.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }
        studentRepo.deleteById(id);
    }

    @Override
    public Studentdto updateAddress(int id, Addressdto addressDto) {
        Student existing = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));

        Address address = modelMapper.map(addressDto, Address.class);
        existing.setAddress(address);
        addressRepo.save(address);

        Student updated = studentRepo.save(existing);
        return modelMapper.map(updated, Studentdto.class);
    }
}
