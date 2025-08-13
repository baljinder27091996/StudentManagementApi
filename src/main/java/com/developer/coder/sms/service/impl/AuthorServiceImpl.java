package com.developer.coder.sms.service.impl;

import com.developer.coder.sms.dto.AuthorRequestDTO;
import com.developer.coder.sms.dto.AuthorResponseDTO;
import com.developer.coder.sms.entity.Author;
import com.developer.coder.sms.exception.AuthorNotFoundException;
import com.developer.coder.sms.mapper.AuthorMapper;
import com.developer.coder.sms.repository.AuthorRepository;
import com.developer.coder.sms.service.Authorservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements Authorservice {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO request) {
        Author author = AuthorMapper.toEntity(request);
        return AuthorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        return AuthorMapper.toDto(author);
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        author.setName(request.getName());
        return AuthorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException(id);
        }
        authorRepository.deleteById(id);
    }
}
