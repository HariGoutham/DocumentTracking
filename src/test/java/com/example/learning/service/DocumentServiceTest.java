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

        Document docSer = docService.findByUUID("471c-9cb8-c27882ea68cbe");
        assertEquals(docSer.getName(), "new_variant_2");
        assertEquals(docSer.getSuperseded(), true);
        assertEquals(docSer.getBusinessId(), "DOC1");
        assertEquals(docSer.getStudy(), "New Study");
    }

}
