package com.example.battlebeiserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName UserWordCollectionDaoTest
 * @Description TODO
 * @Date 2019/5/30 9:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class UserWordCollectionDaoTest {
    @Autowired
    private UserWordCollectionDao userWordCollectionDao;

    @Test
    public void iswordinCollection() {
//        boolean temp=userWordCollectionDao.iswordinCollection("123",56L);
//        System.out.println(temp);
        System.out.println("das");
    }
}