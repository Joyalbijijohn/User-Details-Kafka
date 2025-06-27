package com.example.userdetails.service;

import com.example.userdetails.document.UserDocument;
import com.example.userdetails.model.User;
import com.example.userdetails.repository.UserRepository;
import com.example.userdetails.repository.UserSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserSearchRepository searchRepository;

    public User create(User user) {
        User saved = repository.save(user);

        // Index to Elasticsearch
        UserDocument doc = UserDocument.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .build();

        searchRepository.save(doc);
        return saved;
    }

    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public List<UserDocument> searchByName(String name) {
        return searchRepository.findByNameContainingIgnoreCase(name);
    }
}
