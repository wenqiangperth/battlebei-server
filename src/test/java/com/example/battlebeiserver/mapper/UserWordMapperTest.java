package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName UserWordMapperTest
 * @Description TODO
 * @Date 2019/5/27 10:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class UserWordMapperTest {
    @Autowired
    private UserWordMapper userWordMapper;

    @Test
    public void addUnknownWord() {
//        UserWord userWord=new UserWord();
//        userWord.setOpenId("123");
//        userWord.setWordId(2165L);
//        userWord.setWeight(1);
//        userWord.setDate(new Date());
//        Long a=userWordMapper.addUnknownWord(userWord);
        System.out.println(new Date());
    }
//
//    @Test
//    public void getReviewWord() {
//        ArrayList<Word> words=userWordMapper.getReviewWord("123",2L);
//        System.out.println(words);
//    }
}