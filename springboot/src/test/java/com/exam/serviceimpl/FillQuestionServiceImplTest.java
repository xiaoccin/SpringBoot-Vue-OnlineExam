package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.FillQuestion;
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
public class FillQuestionServiceImplTest {
    FillQuestion question;

    @Resource
    FillQuestionServiceImpl service;

    @Before
    public void before(){
        question = new FillQuestion();
        question.setQuestionId(10001);
        question.setSubject("计算机网络");
        question.setQuestion("收发电子邮件，属于ISO/OSI RM中 ()层的功能。");
        question.setAnswer("应用");
        question.setScore(2);
        question.setLevel("1");
    }

    /*数据库中不存在paperId项，无法执行该函数*/
    /*@Test
    public void findByIdAndType() {
        assertEquals(JSON.toJSONString(question),JSON.toJSONString(service.findByIdAndType(10001)));
    }*/

    @Test
    public void findAll() {
    }

    @Test
    public void findOnlyQuestionId() {
        FillQuestion findquestion = new FillQuestion();
        findquestion.setQuestionId(10030);
        assertEquals(JSON.toJSONString(findquestion),JSON.toJSONString(service.findOnlyQuestionId()));
    }
    /*根据mapper中的sql语句可知，因其sql语句对Id进行降序排序，该函数查询目标为questionId末位，故为10028*/

    @Test
    @Rollback
    @Transactional
    public void add() {
        FillQuestion addQuestion = new FillQuestion();
        addQuestion.setQuestionId(10030);
        addQuestion.setSubject("测试");
        addQuestion.setQuestion("添加测试用问题（）。");
        addQuestion.setAnswer("已添加");
        addQuestion.setScore(2);
        addQuestion.setLevel("1");
        service.add(addQuestion);

        assertEquals(JSON.toJSONString(addQuestion),JSON.toJSONString(service.findById(10030)));
    }

    /*数据库中不存在pageNo项，无法执行sql语句，无法执行函数*/
    /*@Test
    public void findBySubject() {
    }*/
}