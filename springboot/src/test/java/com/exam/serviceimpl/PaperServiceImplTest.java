package com.exam.serviceimpl;

import com.exam.entity.PaperManage;
import com.exam.service.PaperService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.print.Paper;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PaperServiceImplTest {

    PaperManage paper;

    @Resource
    PaperService service;

    @Before
    public void setUp() throws Exception {
        paper = new PaperManage();
        paper.setPaperId(1001);
        paper.setQuestionType(1);
        paper.setQuestionId(10013);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        assertEquals(paper,service.findById(1001));
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
        PaperManage addpaper = new PaperManage();
        addpaper.setPaperId(1001);
        addpaper.setQuestionId(10030);
        addpaper.setQuestionType(2);
        service.add(addpaper);

        //assertEquals(addpaper,service.findById(10001));
    }
}