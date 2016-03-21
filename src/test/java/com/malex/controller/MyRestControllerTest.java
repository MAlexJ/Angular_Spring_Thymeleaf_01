package com.malex.controller;

import com.gargoylesoftware.htmlunit.WebResponse;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitTestingEngineImpl;
import net.sourceforge.jwebunit.junit.JWebUnit;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;


public class MyRestControllerTest {

    @Before
    public void setUp() throws Exception {
        setBaseUrl("http://localhost:8080/");
    }

    @Test
    public void testGetList(){
        beginAt("/phone");

        WebResponse response = ((HtmlUnitTestingEngineImpl) JWebUnit.getTestingEngine()).getWebResponse();

       // check content type
        assertTrue("Response type should be application/json, was: " + response.getContentType(), "application/json".equals(response.getContentType()));
        System.out.println(response.getContentType());
        String json = response.getContentAsString();
        System.out.println(json);
    }

}
