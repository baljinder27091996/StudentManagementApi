package com.developer.coder.sms.controller;

import com.developer.coder.sms.dto.AuthorRequestDTO;
import com.developer.coder.sms.dto.AuthorResponseDTO;
import com.developer.coder.sms.service.Authorservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    private final Authorservice authorService;

    public AuthorController(Authorservice authorService) {
        this.authorService = authorService;
    }
    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody AuthorRequestDTO authorRequestDto) {
        AuthorResponseDTO createdAuthor = authorService.createAuthor(authorRequestDto);
        return ResponseEntity.ok(createdAuthor);
    }
    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors() {
        List<AuthorResponseDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id) {
        AuthorResponseDTO author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(
            @PathVariable Long id,
            @RequestBody AuthorRequestDTO authorRequestDto) {
        AuthorResponseDTO updatedAuthor = authorService.updateAuthor(id, authorRequestDto);
        return ResponseEntity.ok(updatedAuthor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
