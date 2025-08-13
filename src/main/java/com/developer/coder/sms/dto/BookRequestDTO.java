package com.developer.coder.sms.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookRequestDTO {
    private String title;
    private int year;
}
