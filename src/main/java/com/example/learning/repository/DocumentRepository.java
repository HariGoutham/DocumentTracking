package com.example.learning.repository;

import com.example.learning.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, String> {
    DocumentEntity findByStudyEnvironmentUuid(String studyEnvironmentUuid);
}
