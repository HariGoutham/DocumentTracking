package com.example.learning.controller;
import com.example.learning.LearningApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
public class DocumentEntityControllerTest extends LearningApplicationTests {

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

        MockMvc mvc = webAppContextSetup(webApplicationContext).build();
        String studyEnvironmentUuid = "471c-9cb8-c27882ea68cbe";
        String jsonRequest = "{\n" +
                "  \"documentType\": \"Protocol 7\"\n" +
                "}";
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.patch("/documents/" + studyEnvironmentUuid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest);

        mvc.perform(builder);

    }
}
