package com.example.learning.repository;

import com.example.learning.entity.Document;
import com.example.learning.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {

    Document findByStudyEnvironmentUuid(String studyEnvironmentUuid);
}
