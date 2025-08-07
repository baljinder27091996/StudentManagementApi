package com.developer.coder.sms.service.impl;
import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;
import com.developer.coder.sms.exception.DuplicateResourceException;
import com.developer.coder.sms.exception.InvalidInputException;
import com.developer.coder.sms.mapper.StudentMapper;
import com.developer.coder.sms.repository.StudentInterface;
import com.developer.coder.sms.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.developer.coder.sms.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
@Service

public class StudentServiceImpl implements Studentservice{

    @Autowired
    private StudentInterface studentrepository;



    @Override
    public Studentdto createStudent(Studentdto studentdto)
    {
        Student student= StudentMapper.maptoStudent(studentdto);
        Student savedStudent=studentrepository.save(student);

        return StudentMapper.maptoStudentdto(savedStudent);

    }
    @Override
    public Studentdto createStudentifEXCEPTION(Studentdto studentdto) {
        if (studentdto.getRollNo() <= 0) {
            throw new InvalidInputException("Roll number must be greater than zero");
        }
        if (studentrepository.existsByRollNumber(studentdto.getRollNo())) {
            throw new DuplicateResourceException("Student with roll number already exists");
        }

        Student student = StudentMapper.maptoStudent(studentdto);
        return StudentMapper.maptoStudentdto(studentrepository.save(student));
    }
    @Override
    public List<Studentdto> getAllStudents() {
        return studentrepository.findAll()
                .stream()
                .map(StudentMapper::maptoStudentdto) // assuming you have a mapper
                .collect(Collectors.toList());
    }

    @Override
    public Studentdto getStudentById(Integer id) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return StudentMapper.maptoStudentdto(student);
    }

    @Override
    public Studentdto updateStudent(Integer id, Studentdto studentdto) {
        Student existingStudent = studentrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingStudent.setRollNumber(studentdto.getRollNo());

        existingStudent.setName(studentdto.getName());

        existingStudent.setClassName(studentdto.getClassname());

        Student updatedStudent = studentrepository.save(existingStudent);
        return StudentMapper.maptoStudentdto(updatedStudent);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentrepository.delete(student);
    }

}
