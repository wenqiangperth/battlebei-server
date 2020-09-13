package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.BattlebeiServerApplication;
import com.example.battlebeiserver.entity.UserWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName WordPlanMapperTest
 * @Description TODO
 * @Date 2019/5/26 21:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class WordPlanMapperTest {
    @Autowired
    private WordPlanMapper wordPlanMapper;

    @Test
    public void setNowWordPlanPace() {
//        UserWord userWord=new UserWord();
//        userWord.setOpenId("123");
//        Long a=wordPlanMapper.setNowWordPlanPace(userWord);
        System.out.println("dsa");
    }
}