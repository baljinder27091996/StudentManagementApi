package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;
import com.developer.coder.sms.entity.Address;
import java.util.List;
import java.util.stream.Collectors;

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
                student.getAddresses() != null
                        ? student.getAddresses()
                        .stream()
                        .map(AddressMapper::mapToAddressDto)
                        .collect(Collectors.toList())
                        : null
        );
    }

    public static Student mapToStudent(Studentdto studentdto) {
        if (studentdto == null) {
            return null;
        }

        Student student = new Student(
                studentdto.getId(),
                studentdto.getRollNo(),
                studentdto.getName(),
                studentdto.getClassname(),
                null
        );

        if (studentdto.getAddresses() != null) {
            List<Address> addresses = studentdto.getAddresses()
                    .stream()
                    .map(AddressMapper::mapToAddress)
                    .collect(Collectors.toList());

            // Maintain bidirectional relationship
            addresses.forEach(addr -> addr.setStudent(student));
            student.setAddresses(addresses);
        }

        return student;
    }
}
