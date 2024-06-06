package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Score;
import com.exam.service.ScoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class ScoreServiceImplTest {

    Score score;
    @Resource
    ScoreService service;

    @Before
    public void setUp()throws Exception{
        Score score1 = new Score();
        score1.setScoreId(4);
        score1.setExamCode(20190001);
        score1.setStudentId(20154084);
        score1.setSubject("计算机网络");
        score1.setEtScore(70);
        score1.setAnswerDate("2019-04-03");

        Score score2 = new Score();
        score2.setScoreId(14);
        score2.setExamCode(20190002);
        score2.setStudentId(20154084);
        score2.setSubject("数据库理论");
        score2.setEtScore(78);
        score2.setAnswerDate("2019-04-20");
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        assertEquals("",JSON.toJSONString(service.findById(20154084)));
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void findByExamCode() {
    }
}