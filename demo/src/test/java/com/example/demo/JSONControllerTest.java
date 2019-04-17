package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONController.class)
public class JSONControllerTest {
    private String contentTest = "test the demo";
    private static final Log log = LogFactory.getLog(JSONControllerTest.class);

    @Autowired MockMvc mvc;

    @Test
    public void jsonTest() throws Exception {
        PostJSON json = new PostJSON(contentTest);

        MvcResult result = mvc.perform(post("/json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(json)))
                .andExpect(status().isOk())
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        PostJSON resultJSON = new ObjectMapper().readValue(resultContent, PostJSON.class);
//        log.info(resultContent);
        assertTrue(resultJSON.getContent().equals(contentTest));
    }
}
