package com.developer.coder.sms.service;

import com.developer.coder.sms.dto.*;
import java.util.List;

public interface Authorservice {
        AuthorResponseDTO createAuthor(AuthorRequestDTO request);
        List<AuthorResponseDTO> getAllAuthors();
        AuthorResponseDTO getAuthorById(Long id);
        AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO request);
        void deleteAuthor(Long id);
}
