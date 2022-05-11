package com.example.learning.service;

import com.example.learning.entity.DocumentEntity;
import com.example.learning.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentService {

    @Autowired
    private DocumentRepository docRepo;

    public DocumentEntity findByUUID(String uuid) {
        return docRepo.findByStudyEnvironmentUuid(uuid);
    }

    public DocumentEntity save(DocumentEntity doc) {
        return docRepo.save(doc);
    }

    public void deleteById(String uuid) {
         docRepo.deleteById(uuid);
    }
}
