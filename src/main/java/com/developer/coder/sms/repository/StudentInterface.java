package com.developer.coder.sms.repository;
import com.developer.coder.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInterface extends JpaRepository <Student, Integer>{
    boolean existsByRollNumber(int rollNumber);}
