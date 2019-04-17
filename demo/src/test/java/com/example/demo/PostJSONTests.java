package com.example.demo;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PostJSONTests {
    private String contentTest = "test the demo";
    private String contentTest2 = "test the demo two";

    @Test
    public void TestPostJSONConstructor()
    {
        PostJSON json = new PostJSON(contentTest);
        assertTrue(json.getContent().equals(contentTest));
    }

    @Test
    public void TestGetContent(){
        PostJSON json = new PostJSON(contentTest);
        assertTrue(json.getContent().equals(contentTest));
        json.setContent(contentTest2);
        assertTrue(json.getContent().equals(contentTest2));
    }

    @Test
    public void TestSetContent(){
        PostJSON json = new PostJSON();
        json.setContent(contentTest);
        assertTrue(json.getContent().equals(contentTest));
    }
}
