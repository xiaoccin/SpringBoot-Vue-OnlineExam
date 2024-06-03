package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Message;
import com.exam.service.MessageService;
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
@RunWith(SpringRunner.class
)
public class MessageServiceImplTest {
    Message message;

    @Resource
    MessageService service;

    @Before
    public void setUp() throws Exception{
        message = new Message();
        message.setId(15);
        message.setTitle("咸鱼");
        message.setContent("我是一条咸鱼");
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        assertEquals(JSON.toJSONString(message),JSON.toJSONString(service.findById(15)));
    }

    @Test
    @Rollback
    @Transactional
    public void delete() {
        service.delete(35);

        assertEquals(JSON.toJSONString(null),JSON.toJSONString(service.findById(35)));
    }

    @Test
    @Rollback
    @Transactional
    public void update() {
    }

    @Test
    @Rollback
    @Transactional
    public void add() {
    }
}