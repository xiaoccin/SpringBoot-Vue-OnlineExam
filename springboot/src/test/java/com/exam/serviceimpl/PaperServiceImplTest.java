package com.exam.serviceimpl;

import com.exam.service.PaperService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.print.Paper;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PaperServiceImplTest {

    Paper paper;

    @Resource
    PaperService service;

    @Before
    public void setUp() throws Exception {
        paper = new Paper();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void add() {
    }
}