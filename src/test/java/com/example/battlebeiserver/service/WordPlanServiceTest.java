package com.example.battlebeiserver.service;

import com.example.battlebeiserver.entity.UserStatus;
import com.example.battlebeiserver.entity.UserStudyStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName WordPlanServiceTest
 * @Description TODO
 * @Date 2019/5/29 18:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class WordPlanServiceTest {
    @Autowired
    private WordPlanService wordPlanService;

    @Test
    public void getUserStudyStatus() {
//        UserStudyStatus userStudyStatus =wordPlanService.getUserStudyStatus("123");
//        System.out.println(userStudyStatus);
        System.out.println("dsa");
    }
}