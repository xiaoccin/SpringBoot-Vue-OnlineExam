package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.ExamManage;
import org.junit.Assert;
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
public class ExamManageServiceImplTest {

    ExamManage manage;
    @Resource
    ExamManageServiceImpl service;

    @Before
    public void before(){
        manage = new ExamManage();
        manage.setExamCode(20190001);
        manage.setDescription("2019年上期期末考试");
        manage.setSource("计算机网络");
        manage.setPaperId(1001);
        manage.setExamDate("2019-03-21");
        manage.setTotalTime(120);
        manage.setGrade("2018");
        manage.setTerm("1");
        manage.setMajor("计算机科学与技术");
        manage.setInstitute("软件工程学院");
        manage.setTotalScore(100);
        manage.setType("期末考试");
        manage.setTips("快乐千万条，学习第一条，平时不努力，考试两行泪。");
    }


    @Test
    public void findAll() {
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void findById() {
        assertEquals(JSON.toJSONString(manage) ,JSON.toJSONString(service.findById(20190001)));
    }

    @Test
    @Rollback
    @Transactional
    public void delete() {
        service.delete(20190015);
        assertEquals(JSON.toJSONString(null),JSON.toJSONString(service.findById(20190015)));
    }

    @Test
    public void update() {
        ExamManage updateManage = new ExamManage();
        updateManage.setExamCode(20190001);
        updateManage.setDescription("2019年上期期末考试");
        updateManage.setSource("计算机网络");
        updateManage.setPaperId(1001);
        updateManage.setExamDate("2019-03-21");
        updateManage.setTotalTime(120);
        updateManage.setGrade("2018");
        updateManage.setTerm("1");
        updateManage.setMajor("计算机科学与技术");
        updateManage.setInstitute("软件工程学院");
        updateManage.setTotalScore(100);
        updateManage.setType("期末考试");
        updateManage.setTips("快乐千万条，学习第一条，平时不努力，考试两行泪。");
        service.update(updateManage);

        assertEquals(JSON.toJSONString(updateManage),JSON.toJSONString(service.findById(20190001)));
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
        ExamManage addManage = new ExamManage();
        addManage.setExamCode(20190024);
        addManage.setDescription("2024年上期期末考试");
        addManage.setSource("软件测试");
        addManage.setPaperId(1001);
        addManage.setExamDate("2024-06-27");
        addManage.setTotalTime(200);
        addManage.setGrade("2021");
        addManage.setTerm("1");
        addManage.setMajor("计算机科学与技术");
        addManage.setInstitute("软件工程学院");
        addManage.setTotalScore(100);
        addManage.setType("期末考试");
        addManage.setTips("快乐千万条，学习第一条，平时不努力，考试两行泪。");
        service.add(addManage);

        assertEquals(JSON.toJSONString(addManage),JSON.toJSONString(service.findById(20190024)));
    }

    @Test
    public void findOnlyPaperId() {
        ExamManage e = new ExamManage();
        e.setPaperId(1009);
        assertEquals(JSON.toJSONString(e),JSON.toJSONString(service.findOnlyPaperId()));
    }
}