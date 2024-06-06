package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.Message;
import com.exam.entity.Replay;
import com.exam.service.MessageService;
import com.exam.service.ReplayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class
)
public class MessageServiceImplTest {
    Message message;
    Replay replay;

    @Resource
    MessageService mservice;
    ReplayService rservice;

    @Before
    public void setUp() throws Exception{
        DateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date=null;
        String str="2019-03-18";
        date=format.parse(str);
        message = new Message();
        message.setId(15);
        message.setTitle("咸鱼");
        message.setContent("我是一条咸鱼");
        message.setTime(date);
        //message.setReplays(replay.setMessageId(15),replay.setReplayId(9),replay.setReplay("咸鱼其实还可以吃，而你,emmmm"));

    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        assertEquals(JSON.toJSONString(message),JSON.toJSONString(mservice.findById(15)));
    }

    @Test
    @Rollback
    @Transactional
    public void delete() {
        mservice.delete(35);

        assertEquals(JSON.toJSONString(null),JSON.toJSONString(mservice.findById(35)));
        assertEquals("该message不存在",mservice.delete(60));
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