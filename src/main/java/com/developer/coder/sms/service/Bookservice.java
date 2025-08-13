package com.developer.coder.sms.service;

import com.developer.coder.sms.dto.BookRequestDTO;
import com.developer.coder.sms.dto.BookResponseDTO;
import java.util.List;

public interface Bookservice {
    BookResponseDTO createBook(Long authorId, BookRequestDTO request);
    List<BookResponseDTO> getAllBooks();
    List<BookResponseDTO> getBooksByAuthor(Long authorId);
    BookResponseDTO getBookById(Long id);
    BookResponseDTO updateBook(Long id, BookRequestDTO request);
    void deleteBook(Long id);
}
