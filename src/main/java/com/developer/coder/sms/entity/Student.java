package com.developer.coder.sms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rollno", unique = true)
    private int rollNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "classname")
    private String className;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Student() {
    }

    public Student(int id,
                   @NotNull(message = "Roll number is required")
                   @Positive(message = "Roll number must be positive") int rollNo,
                   @NotBlank(message = "Name is mandatory")
                   @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name,
                   @NotBlank(message = "Class name is mandatory") String classname,
                   List<Address> addresses) {
        this.id = id;
        this.rollNumber = rollNo;
        this.name = name;
        this.className = classname;
        this.addresses = addresses;
    }
    public void addAddress(Address address) {
        addresses.add(address);
        address.setStudent(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setStudent(null);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
