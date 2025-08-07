package com.developer.coder.sms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Studentdto {

    private int id;
    @NotNull(message = "Roll number is required")
    @Positive(message = "Roll number must be positive")
    private int rollNo;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotBlank(message = "Class name is mandatory")
    private String classname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Studentdto(int id, int rollNo, String name, String classname) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.classname = classname;
    }

    public Studentdto() {
    }

    @Override
    public String toString() {
        return "Studentdto{" +
                "id=" + id +
                ", rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
