package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Admin;
import com.exam.service.AdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)

public class AdminServiceImplTest {

    private Admin admin;
    @Resource
    private AdminService adminService;
    @Before
    public void setUp() throws Exception {

        admin = new Admin();
        admin.setAdminName("超级管理员");
        admin.setSex("男");
        admin.setTel("13658377857");
        admin.setEmail("1253838283@qq.com");
        admin.setCardId("3132");
        admin.setRole("0");
    }

    @Test
    public void findById() throws Exception{
        assertEquals(JSON.toJSONString(admin) ,JSON.toJSONString(adminService.findById(9527)) );
    }
}