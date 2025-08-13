package com.developer.coder.sms.controller;
import com.developer.coder.sms.dto.BookRequestDTO;
import com.developer.coder.sms.dto.BookResponseDTO;
import com.developer.coder.sms.service.Bookservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final Bookservice bookService;
    public BookController(Bookservice bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/author/{authorId}")
    public ResponseEntity<BookResponseDTO> createBook(
            @PathVariable Long authorId,
            @RequestBody BookRequestDTO requestDto) {
        BookResponseDTO createdBook = bookService.createBook(authorId, requestDto);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDTO requestDto) {
        return ResponseEntity.ok(bookService.updateBook(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
