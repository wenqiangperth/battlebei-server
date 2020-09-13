package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.UserStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName UserStatusDaoTest
 * @Description TODO
 * @Date 2019/5/27 19:23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class UserStatusDaoTest {
    @Autowired
    private UserStatusDao userStatusDao;
    private UserStatus userStatus;

    @Before
    public void setup(){
        userStatus=new UserStatus();
        userStatus.setOpenId("124");
    }

//    @Test
//    public void addUserStatusStudyNum() {
//        Long temp=userStatusDao.addUserStatusStudyNum(userStatus);
//        System.out.println(temp);
//    }
//
    @Test
    public void addUserStatusReviewNum() {
      //  Long temp=userStatusDao.addUserStatusReviewNum(userStatus);
        int a=6;
        Long b=4L;
        System.out.println(a/b);
    }

}