package com.example.learning.service;

import com.example.learning.entity.Document;
import com.example.learning.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DocumentService {

    @Autowired
    private DocumentRepository docRepo;

    public Document findByUUID(String uuid) {
        return docRepo.findByStudyEnvironmentUuid(uuid);
    }
    public Document save(Document doc) {
        return docRepo.save(doc);
    }
}
