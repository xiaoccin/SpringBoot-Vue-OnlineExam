package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Student;
import com.exam.service.StudentService;
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

public class StudentServiceImplTest {

    Student student;
    @Resource
    StudentService service;
    @Before
    public void setUp() throws Exception {
        student = new Student();
        student.setStudentId(20154084);
        student.setStudentName("大咸鱼");
        student.setGrade("2015");
        student.setMajor("计算机科学与技术");
        student.setClazz("2");
        student.setInstitute("软件工程学院");
        student.setTel("13658377857");
        student.setEmail("13658377857@sina.cn");
        student.setPwd("123456");
        student.setCardId("124123124535");
        student.setSex("男");
        student.setRole("2");
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        assertEquals(JSON.toJSONString(student),JSON.toJSONString(service.findById(20154084)));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteById() {
        service.deleteById(20155003);
        assertEquals(JSON.toJSONString(null),JSON.toJSONString(service.findById(20155003)));
    }

    @Test
    @Rollback
    @Transactional
    public void update() {
        Student updateStudent = new Student();
        updateStudent.setStudentId(20154084);
        updateStudent.setStudentName("小咸鱼");
        updateStudent.setGrade("2015");
        updateStudent.setMajor("计算机科学和技术");
        updateStudent.setClazz("2");
        updateStudent.setInstitute("硬件工程学院");
        updateStudent.setTel("13658377857");
        updateStudent.setEmail("13658377857@sina.cn");
        updateStudent.setPwd("123456");
        updateStudent.setCardId("124123124535");
        updateStudent.setSex("男");
        updateStudent.setRole("2");
        service.update(updateStudent);

        assertEquals(JSON.toJSONString(updateStudent),JSON.toJSONString(service.findById(20154084)));
    }

    @Test
    @Rollback
    @Transactional
    public void updatePwd() {
        student.setPwd("111234");
        service.updatePwd(student);

        assertEquals(JSON.toJSONString(student),JSON.toJSONString(service.findById(20154084)));
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
        Student addstudent = new Student();
        addstudent.setStudentId(20218822);
        addstudent.setStudentName("大鲨鱼");
        addstudent.setGrade("2021");
        addstudent.setMajor("计算机科学与技术");
        addstudent.setClazz("3");
        addstudent.setInstitute("软件工程学院");
        addstudent.setTel("12345678901");
        addstudent.setEmail("12345678901@qq.cn");
        addstudent.setPwd("432111");
        addstudent.setCardId("124123124535");
        addstudent.setSex("男");
        addstudent.setRole("1");
        service.add(addstudent);

        assertEquals(JSON.toJSONString(addstudent),JSON.toJSONString(service.findById(20218822)));
    }
}