package com.developer.coder.sms.mapper;

import com.developer.coder.sms.dto.AuthorRequestDTO;
import com.developer.coder.sms.dto.AuthorResponseDTO;
import com.developer.coder.sms.entity.Author;

import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorResponseDTO toDto(Author author) {
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());

        dto.setBooks(
                author.getBooks().stream()
                        .map(BookMapper::toDto)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    public static Author toEntity(AuthorRequestDTO dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());

        if (dto.getBooks() != null) {
            dto.getBooks().forEach(b -> {
                var bookEntity = BookMapper.toEntity(b);
                bookEntity.setAuthor(author);
                author.getBooks().add(bookEntity);
            });
        }

        return author;
    }
}
