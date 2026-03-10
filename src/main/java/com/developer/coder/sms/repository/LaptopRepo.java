package com.developer.coder.sms.repository;

import com.developer.coder.sms.entity.Emp;
import com.developer.coder.sms.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {
}
