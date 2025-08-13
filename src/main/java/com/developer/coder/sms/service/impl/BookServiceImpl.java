package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.BookRequestDTO;
import com.developer.coder.sms.dto.BookResponseDTO;
import com.developer.coder.sms.entity.Author;
import com.developer.coder.sms.entity.Book;
import com.developer.coder.sms.exception.AuthorNotFoundException;
import com.developer.coder.sms.exception.BookNotFoundException;
import com.developer.coder.sms.mapper.BookMapper;
import com.developer.coder.sms.repository.AuthorRepository;
import com.developer.coder.sms.repository.BookRepository;
import com.developer.coder.sms.service.Bookservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements Bookservice {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    @Override
    public BookResponseDTO createBook(Long authorId, BookRequestDTO request) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = BookMapper.toEntity(request);
        book.setAuthor(author);
        return BookMapper.toDto(bookRepo.save(book));
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponseDTO> getBooksByAuthor(Long authorId) {
        return bookRepo.findByAuthorId(authorId)
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        return BookMapper.toDto(
                bookRepo.findById(id)
                        .orElseThrow(() -> new BookNotFoundException(id))
        );
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO request) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(request.getTitle());
        book.setYear(request.getYear());
        return BookMapper.toDto(bookRepo.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepo.deleteById(id);
    }
}
