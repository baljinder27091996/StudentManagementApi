package com.developer.coder.sms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    private Addressdto address;

    @Override
    public String toString() {
        return "Studentdto{" +
                "id=" + id +
                ", rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", address=" + address +
                '}';
    }
}
