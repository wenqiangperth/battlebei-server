package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName WordCollectionMapperTest
 * @Description TODO
 * @Date 2019/5/27 21:36
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class WordCollectionMapperTest {
    @Autowired
    private WordCollectionMapper wordCollectionMapper;

//    @Test
//    public void addWordCollection() {
//        UserWord userWord=new UserWord();
//        userWord.setOpenId("456");
//        userWord.setWordId(2256L);
//        wordCollectionMapper.addWordCollection(userWord);
//    }
//
    @Test
    public void getUserWordCollectionForBattle() {
       // ArrayList<Word> words=wordCollectionMapper.getUserWordCollectionForBattle("456",2L);
        System.out.println("ds");
    }
}