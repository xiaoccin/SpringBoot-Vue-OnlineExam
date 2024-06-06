package com.exam.serviceimpl;

import com.exam.entity.Replay;
import com.exam.service.ReplayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class ReplayServiceImplTest {

    Replay replay;
    @Resource
    ReplayService service;
    @Before
    public void setUp() throws Exception {
        replay = new Replay();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllById() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void add() {
    }
}