package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Teacher;
import com.exam.service.TeacherService;
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

public class TeacherServiceImplTest {
    Teacher teacher;
    @Resource
    TeacherService service;
    @Before
    public void setUp() throws Exception {
        teacher = new Teacher();
        teacher.setTeacherId(20081001);
        teacher.setTeacherName("张");
        teacher.setInstitute("软件工程学院");
        teacher.setSex("男");
        teacher.setTel("13598458442");
        teacher.setEmail("13598458442@163.com");
        teacher.setPwd("123456");
        teacher.setCardId("423423283498");
        teacher.setType("讲师");
        teacher.setRole("1");
    }

    @Test
    public void findAll() {
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void findById() {
        assertEquals(JSON.toJSONString(teacher),JSON.toJSONString(service.findById(20081001)));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteById() {
        service.deleteById(20081002);
        assertEquals(JSON.toJSONString(null),JSON.toJSONString(service.findById(20081002)));
    }

    @Test
    @Rollback
    @Transactional
    public void update() {
        Teacher updateteacher = new Teacher();
        updateteacher.setTeacherId(20081001);
        updateteacher.setTeacherName("弓长");
        updateteacher.setInstitute("软件工程学院");
        updateteacher.setSex("男");
        updateteacher.setTel("13598458442");
        updateteacher.setEmail("13598458442@163.com");
        updateteacher.setPwd("123321");
        updateteacher.setCardId("423423283498");
        updateteacher.setType("教师");
        updateteacher.setRole("1");
        service.update(updateteacher);

        assertEquals(JSON.toJSONString(updateteacher),JSON.toJSONString(service.findById(20081001)));
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
        Teacher addteacher = new Teacher();
        addteacher.setTeacherId(20081010);
        addteacher.setTeacherName("弓长");
        addteacher.setInstitute("软件工程学院");
        addteacher.setSex("男");
        addteacher.setTel("1231221345");
        addteacher.setEmail("1231221345@163.com");
        addteacher.setPwd("123789");
        addteacher.setCardId("24241234");
        addteacher.setType("讲师");
        addteacher.setRole("2");
        service.add(addteacher);

        assertEquals(JSON.toJSONString(addteacher),JSON.toJSONString(service.findById(20081010)));
    }

}