package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.util.MyHttp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perth
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/5/29 17:56
 **/
@RestController
public class UserController {

    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "code")String code){
        MyHttp myHttp=new MyHttp();
        String temp=myHttp.doget(code);
        return temp;
    }
}
