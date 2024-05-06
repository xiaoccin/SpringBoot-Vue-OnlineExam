package com.exam.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        System.out.println("-------------------start-------------------");

    }

    @Test
    @Transactional
    @Rollback
    public void findAll() throws Exception{
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/admins"));
        resultActions.andReturn().getResponse().setCharacterEncoding("utf-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
    }

    @Test
    public void findById() {
    }
}