package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;

public class StudentMapper {

    public static Studentdto mapToStudentDto(Student student) {
        if (student == null) {
            return null;
        }
        return new Studentdto(
                student.getId(),
                student.getRollNumber(), // ensure naming matches Student entity
                student.getName(),
                student.getClassName(),
                AddressMapper.mapToAddressDto(student.getAddress())
        );
    }

    public static Student mapToStudent(Studentdto studentdto) {
        if (studentdto == null) {
            return null;
        }
        return new Student(
                studentdto.getId(),
                studentdto.getRollNo(), // matches DTO field
                studentdto.getName(),
                studentdto.getClassname(), // fixed getter name
                AddressMapper.mapToAddress(studentdto.getAddress())
        );
    }
}
