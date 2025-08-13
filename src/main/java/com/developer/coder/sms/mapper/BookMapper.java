package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.BookRequestDTO;
import com.developer.coder.sms.dto.BookResponseDTO;
import com.developer.coder.sms.entity.Book;

public class BookMapper {

    public static BookResponseDTO toDto(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setYear(book.getYear());
        return dto;
    }

    public static Book toEntity(BookRequestDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setYear(dto.getYear());
        return book;
    }
}
