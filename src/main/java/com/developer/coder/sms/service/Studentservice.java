package com.developer.coder.sms.service;

import com.developer.coder.sms.dto.Addressdto;
import com.developer.coder.sms.dto.Studentdto;
import java.util.List;

public interface Studentservice {

        Studentdto createStudent(Studentdto studentdto);

        List<Studentdto> getAllStudents();

        Studentdto getStudentById(Integer id);

        Studentdto updateStudent(Integer id, Studentdto studentdto);

        void deleteStudent(Integer id);

        // Get all addresses for a student
        List<Addressdto> getAddressesByStudentId(int studentId);

        Studentdto updateAddress(int studentId, Addressdto addressDto);
}
