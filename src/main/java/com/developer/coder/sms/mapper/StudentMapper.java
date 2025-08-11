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
                student.getRollNumber(),
                student.getName(),
                student.getClassName(),
                AddressMapper.mapToAddressDto(student.getAddress()) // ✅ include address
        );
    }

    public static Student mapToStudent(Studentdto studentdto) {
        if (studentdto == null) {
            return null;
        }
        return new Student(
                studentdto.getId(),
                studentdto.getRollNo(),
                studentdto.getName(),
                studentdto.getClassname(),
                AddressMapper.mapToAddress(studentdto.getAddress()) // ✅ include address
        );
    }
}
