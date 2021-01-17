package com.example.accessingneo4jdatarest;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void OnRootIsOk() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void OnRootIs2xxSuccessful() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void OnProfileIsOk() throws Exception {
        this.mockMvc.perform(get("/profile")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void OnProfileIs2xxSuccessful() throws Exception {
        this.mockMvc.perform(get("/profile")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void OnOwnersProfileReturnsOk() throws Exception {
        this.mockMvc.perform(get("/profile/owners")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void OnOwnersProfileIs2xxSuccessful() throws Exception {
        this.mockMvc.perform(get("/profile/owners")).andDo(print()).andExpect(status().is2xxSuccessful());
    }

}
