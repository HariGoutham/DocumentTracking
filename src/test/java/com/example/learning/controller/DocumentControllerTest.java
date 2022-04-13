package com.example.learning.controller;

import com.example.learning.LearningApplicationTests;
import com.example.learning.entity.Document;
import com.example.learning.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
public class DocumentControllerTest extends LearningApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void getDocumentTest() throws Exception {
        MockMvc mvc = webAppContextSetup(webApplicationContext).build();
        String uri = "/documents/471c-9cb8-c27882ea68cbe";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
    @Test
    public void testpatch() throws Exception{
        /*DocumentService documentService = new DocumentService();

        Document headFirstJavaBook = new Document("00bd48f1-5cd3-471c-9cb8", "test:vaccine_trail", "345673",
                "vaccine study", "polio vaccination study",
                "Protocol Amendment", "1.0", new Date(),
                "616779", 0, "61677956", "vaccination",
                new Date(), new Date(), "test:vaccine_trail", 0);
       // Document headFirstDesignPatternBook = new Document("2", "Head First Design Pattern", "Packt");

        documentService.save(headFirstJavaBook);
        documentService.save(headFirstJavaBook);


        Document actualBook = documentService.findByUUID("1");

        assertEquals("1", actualBook.getStudyEnvironmentUuid());
        assertEquals("Head First Java", actualBook.getDocumentType());

    }*/
        MockMvc mvc = webAppContextSetup(webApplicationContext).build();
        String studyEnvironmentUuid = "471c-9cb8-c27882ea68cbe";
        String documentType = "new updated content";
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/documents/" + studyEnvironmentUuid)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");

        mvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
         .andExpect(MockMvcResultMatchers.content()
                .string("DOCUMENT updated with documenttype: " + documentType))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testpost() throws Exception{
        MockMvc mvc = webAppContextSetup(webApplicationContext).build();
        String studyEnvironmentUuid = "471c-9cb8-c27882ea68cbe";
        String documentType = "new updated content";
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/documents/" + studyEnvironmentUuid)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8");
        mvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("DOCUMENT created with documenttype: " + documentType))
                .andDo(MockMvcResultHandlers.print());
    }
}


