package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Admin;
import com.exam.service.AdminService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        admin.setAdminId(9527);
        admin.setAdminName("超级管理员");
        admin.setSex("男");
        admin.setTel("13658377857");
        admin.setEmail("1253838283@qq.com");
        admin.setPwd("123456");
        admin.setCardId("3132");
        admin.setRole("0");
    }


    @Test
    /**
     * 测试用例：hjhhhf
     * 测试结果：程序错误
     * 原因：未进行非法格式拦截
     *
     * 测试用例：2819281092
     * 测试结果：程序错误
     * 原因：整数过大，未进行超出int类型约束时输入Id的控制
     *
     * 测试用例：9530
     * 测试结果：程序错误
     * 原因：输入值不存在，没有对不存在的内容进行控制
     */
    public void findById() throws Exception{
        assertEquals(JSON.toJSONString(admin),JSON.toJSONString(adminService.findById(9527)) );
        assertEquals("adminid not found",adminService.findById(9530));
        //assertEquals("id不应为字符串",adminService.findById(access));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteById() throws Exception{
        adminService.deleteById(9528);
        adminService.deleteById(9530);
        assertEquals(JSON.toJSONString(null),JSON.toJSONString(adminService.findById(9528)));
        assertEquals(JSON.toJSONString(null),JSON.toJSONString(adminService.findById(9530)));
    }

    @Test
    @Rollback
    @Transactional
    public void update() throws Exception{
        Admin updateAdmin = new Admin();
        updateAdmin.setAdminId(9528);
        updateAdmin.setAdminName("超级管理员");
        updateAdmin.setSex("男");
        updateAdmin.setTel("13658377857");
        updateAdmin.setEmail("1253838283@qq.com");
        updateAdmin.setPwd("111234");
        updateAdmin.setCardId("3132");
        updateAdmin.setRole("0");
        adminService.update(updateAdmin);

        assertEquals(JSON.toJSONString(updateAdmin),JSON.toJSONString(adminService.findById(9528)));
    }

    @Test
    @Rollback
    @Transactional
    public void add() throws Exception{
        Admin addAdmin = new Admin();
        addAdmin.setAdminId(9530);
        addAdmin.setAdminName("超级管理员");
        addAdmin.setSex("男");
        addAdmin.setTel("13658377857");
        addAdmin.setEmail("1253838283@qq.com");
        addAdmin.setPwd("111111");
        addAdmin.setCardId("3132");
        addAdmin.setRole("0");
        adminService.add(addAdmin);

        assertEquals(JSON.toJSONString(addAdmin),JSON.toJSONString(adminService.findById(9530)));
    }
}

