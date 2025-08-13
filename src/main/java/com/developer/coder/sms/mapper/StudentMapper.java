package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;

public class StudentMapper {

    public static Studentdto mapToStudentDto(Student student) {
        if (student == null) {
            return null;
        }
        return Studentdto.builder()
                .id(student.getId())
                .rollNo(student.getRollNumber()) // matches entity field
                .name(student.getName())
                .classname(student.getClassName())
                .address(AddressMapper.mapToAddressDto(student.getAddress()))
                .build();
    }

    public static Student mapToStudent(Studentdto studentdto) {
        if (studentdto == null) {
            return null;
        }
        return Student.builder()
                .id(studentdto.getId())
                .rollNumber(studentdto.getRollNo()) // matches DTO field
                .name(studentdto.getName())
                .className(studentdto.getClassname()) // fixed getter name
                .address(AddressMapper.mapToAddress(studentdto.getAddress()))
                .build();
    }
}
