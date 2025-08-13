package com.developer.coder.sms.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Data
public class AuthorRequestDTO {
    private String name;
    private String email;
    private List<BookRequestDTO> books;
}
