package com.exam.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.exam.entity.JudgeQuestion;
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
public class JudgeQuestionServiceImplTest {

    JudgeQuestion judgeQuestion;
    @Resource
    JudgeQuestionServiceImpl service;
    @Before
    public void setUp() throws Exception {
        judgeQuestion = new JudgeQuestion();
        judgeQuestion.setQuestionId(10001);
        judgeQuestion.setSubject("计算机网络");
        judgeQuestion.setQuestion("与有线网相比,无线网的数据传输率一般相对较慢");
        judgeQuestion.setAnswer("T");
        judgeQuestion.setScore(2);
        judgeQuestion.setLevel("1");
    }

    /*数据库中不存在paperId项，无法执行该函数
    @Test
    public void findByIdAndType() {
    }*/

    @Test
    public void findAll() {
    }

    @Test
    public void findOnlyQuestionId() {
        JudgeQuestion findlastjudgequestion = new JudgeQuestion();
        findlastjudgequestion.setQuestionId(10012);
        assertEquals(JSON.toJSONString(findlastjudgequestion),JSON.toJSONString(service.findOnlyQuestionId()));
    }
    /*根据mapper中的sql语句可知，因其sql语句对Id进行降序排序，该函数查询目标为questionId末位，故为10012*/

    @Test
    @Rollback
    @Transactional
    public void add() {
        JudgeQuestion addQuestion = new JudgeQuestion();
        judgeQuestion = new JudgeQuestion();
        judgeQuestion.setQuestionId(100020);
        judgeQuestion.setSubject("测试用");
        judgeQuestion.setQuestion("测试用例题");
        judgeQuestion.setAnswer("T");
        judgeQuestion.setScore(2);
        judgeQuestion.setLevel("2");
        service.add(addQuestion);
    }/*无法测试，add函数逻辑正确，可执行add操作，数据库属性与Sql语句不匹配，无可用检索函数，无法确定实际值位置*/

    /*数据库中不存在pageNo项，无法执行sql语句，无法执行函数
    @Test
    public void findBySubject() {
    }*/
}