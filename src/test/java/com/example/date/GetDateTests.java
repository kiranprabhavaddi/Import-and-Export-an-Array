package com.example.date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GetDateTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetDate() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.TEXT_PLAIN);
        MvcResult result = mockMvc.perform(mockRequest).andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

        String strDate = formDate.format(new Date());
        assertEquals(strDate,content);
    }
}
