package com.example.learning.service;

import com.example.learning.LearningApplicationTests;
import com.example.learning.entity.Document;
import com.example.learning.repository.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class DocumentServiceTest extends LearningApplicationTests {

    @InjectMocks
    DocumentService docService;

    @Mock
    DocumentRepository docRepository;

    @Test
    public void getDocumentTest(){
        Document doc = new Document();
        doc.setName("new_variant_2");
        doc.setSuperseded(true);
        doc.setBusinessId("DOC1");
        doc.setStudy("New Study");
        Mockito.when(docRepository.findByStudyEnvironmentUuid(anyString())).thenReturn(doc);
        assertEquals(doc.getName(), "new_variant_2");
        assertEquals(doc.getSuperseded(), true);
        assertEquals(doc.getBusinessId(), "DOC1");
        assertEquals(doc.getStudy(), "New Study");
    }

}
