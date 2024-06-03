package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Login;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class LoginServiceImplTest {

    Login login;
    @Resource
    LoginServiceImpl service;
    @Before
    public void setUp() throws Exception{
        login = new Login();
    }

    @Test
    public void adminLogin() {
        Login adminLogin = new Login();
        adminLogin.setUsername(9527);
        adminLogin.setPassword("123456");

        assertEquals(JSON.toJSONString(service.adminLogin(adminLogin.getUsername(),adminLogin.getPassword())),
                JSON.toJSONString(service.adminLogin(9527,"123456")));
    }

    @Test
    public void teacherLogin() {
        Login teacherLogin = new Login();
        teacherLogin.setUsername(20081001);
        teacherLogin.setPassword("123456");

        assertEquals(JSON.toJSONString(service.teacherLogin(teacherLogin.getUsername(),teacherLogin.getPassword())),
                JSON.toJSONString(service.teacherLogin(20081001,"123456")));
    }

    @Test
    public void studentLogin() {
        Login studentLogin = new Login();
        studentLogin.setUsername(20154084);
        studentLogin.setPassword("123456");

        assertEquals(JSON.toJSONString(service.studentLogin(studentLogin.getUsername(),studentLogin.getPassword())),
                JSON.toJSONString(service.studentLogin(20154084,"123456")));
    }
}