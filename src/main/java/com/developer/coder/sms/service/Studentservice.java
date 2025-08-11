package com.developer.coder.sms.service;
import com.developer.coder.sms.dto.Studentdto;
import com.developer.coder.sms.entity.Student;

import java.util.List;
public interface Studentservice {
        Studentdto createStudent(Studentdto studentdto);
        List<Studentdto> getAllStudents(); // <-- Add this
        Studentdto getStudentById(Integer id);
        Studentdto updateStudent(Integer id, Studentdto studentdto);
        void deleteStudent(Integer id);
        Studentdto createStudentifEXCEPTION(Studentdto studentdto);
        Student Updateaddress(int id, Student student);

}
