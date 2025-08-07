package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;

public class StudentMapper {

    public static com.developer.coder.sms.dto.Studentdto maptoStudentdto(Student student) {
        return new Studentdto(
                student.getId(),
                student.getRollNumber(),
                student.getName(),
                student.getClassName()
        );

    }
    public static Student maptoStudent(Studentdto studentdto){
    return new Student(
            studentdto.getId(),
            studentdto.getRollNo(),
            studentdto.getName(),
            studentdto.getClassname()
    );}
}
