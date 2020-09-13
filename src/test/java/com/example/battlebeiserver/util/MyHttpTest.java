package com.example.battlebeiserver.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author perth
 * @ClassName MyHttpTest
 * @Description TODO
 * @Date 2019/5/29 17:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(value = "BattlebeiServerApplication.class")
public class MyHttpTest {

    @Test
    public void doget() {
        MyHttp myHttp=new MyHttp();
        myHttp.doget("011YSfof1vke8s09T2nf1mSgof1YSfoC");
    }
}