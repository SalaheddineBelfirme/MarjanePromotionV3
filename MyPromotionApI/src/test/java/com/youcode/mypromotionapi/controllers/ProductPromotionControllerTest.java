package com.youcode.mypromotionapi.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import  static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import  static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductPromotionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void createPromotion() {
    }

    @Test
    void getall() throws Exception{
        mockMvc.perform(get("/api/productPromotion").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));

    }
}