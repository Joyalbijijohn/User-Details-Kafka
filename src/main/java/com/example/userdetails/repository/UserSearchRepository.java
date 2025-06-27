package com.example.userdetails.repository;

import com.example.userdetails.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserSearchRepository extends ElasticsearchRepository<UserDocument, Long> {
    List<UserDocument> findByNameContainingIgnoreCase(String name);
}
