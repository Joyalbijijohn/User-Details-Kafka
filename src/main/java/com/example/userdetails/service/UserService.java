package com.example.userdetails.service;

import com.example.userdetails.model.User;
import com.example.userdetails.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @SneakyThrows
    public List<User> getAll() {
        return repository.findAll();
    }
}
