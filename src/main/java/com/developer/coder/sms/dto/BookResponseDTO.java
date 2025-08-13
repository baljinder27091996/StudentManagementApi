package com.developer.coder.sms.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookResponseDTO {
    private Long id;
    private String title;
    private int year;
}
