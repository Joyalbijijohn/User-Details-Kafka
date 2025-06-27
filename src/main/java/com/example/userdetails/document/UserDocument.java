package com.example.userdetails.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDocument {
    @Id
    private Long id;
    private String name;
    private String email;
}
