package com.developer.coder.sms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Addressdto {
    private Integer id;
    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zipcode is required")
    private String zipcode;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getstreet() {
        return street;
    }

    public String getcity() {
        return city;
    }

    public String getstate() {
        return state;
    }

    public String getzipcode() {
        return zipcode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipcode) {
        this.zipcode = zipcode;
    }


}
