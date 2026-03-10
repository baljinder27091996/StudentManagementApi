package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.EmpRequest;
import com.developer.coder.sms.entity.Emp;
import com.developer.coder.sms.entity.Laptop;
import com.developer.coder.sms.repository.EmpRepo;
import com.developer.coder.sms.repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/emp")
@CrossOrigin("*")
public class EmpController {


    @Autowired
    LaptopRepo laptopRepo;


    @Autowired
    EmpRepo empRepo;


    @PostMapping
    public ResponseEntity<?> saveEmp(@RequestBody EmpRequest empRequest){

        Emp emp = new Emp();
        emp.setEmpName(empRequest.getEmpName());
        emp.setLaptop(laptopRepo.findById(empRequest.getLaptopId()).get());
        return new ResponseEntity<>(empRepo.save(emp), HttpStatus.CREATED);
    }

}
