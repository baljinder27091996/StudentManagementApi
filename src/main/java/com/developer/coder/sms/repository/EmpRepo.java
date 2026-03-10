package com.developer.coder.sms.repository;

import com.developer.coder.sms.entity.Address;
import com.developer.coder.sms.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer> {
}
