package com.developer.coder.sms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Student() {
    }

    public Student(int id,
                   @NotNull(message = "Roll number is required")
                   @Positive(message = "Roll number must be positive") int rollNo,
                   @NotBlank(message = "Name is mandatory")
                   @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name,
                   @NotBlank(message = "Class name is mandatory") String classname,
                   Address address) {
        this.id = id;
        this.rollNumber = rollNo;
        this.name = name;
        this.className = classname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", address=" + address +
                '}';
    }
}
