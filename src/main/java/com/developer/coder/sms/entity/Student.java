package com.developer.coder.sms.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Data
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="rollno",unique=true)
    private int rollNumber;
    @Column(name="name")
    private String name;

    @Column(name="classname")
    private String className;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Student() {
    }

    public Student(int id, int rollNumber, String name, String className) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.className = className;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
