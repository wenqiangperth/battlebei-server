package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.UserStudyStatus;
import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.service.WordPlanService;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@ClassName WordPlanController
 *@Description TODO
 *@author perth
 *@Date 2019/5/14 21:15
 **/
@RestController
public class WordPlanController {
    @Autowired
    private WordPlanService wordPlanService;


    /**
     * 设置单词计划
     * 1、openid,presentFlag=true,dailyNum =》设置单词量
     * 2、设置新计划
     * 3、更新计划为当前计划
     * @param wordPlan
     * @return
     */
    @PostMapping(value = "/wordplan")
    public Long setWordPlan(@RequestBody WordPlan wordPlan){
        return wordPlanService.setWordPlan(wordPlan);
    }

    /**
     * 获得用户当前计划
     * @param openId
     * @return
     */
    @GetMapping(value = "/wordplan")
    public WordPlan getWordPlan(@RequestParam(value = "openId")String openId){
        return wordPlanService.getNowWordPlan(openId);
    }

    /**
     * 获得用户学习情况
     * @param openId
     * @return
     */
    @GetMapping(value = "/UserStudyStatus")
    public UserStudyStatus getUserStudyStatus(@RequestParam(value = "openId")String openId){
        return wordPlanService.getUserStudyStatus(openId);
    }

    @PostMapping(value = "/try")
    public void test(@RequestBody WordPlan wordPlan){
        System.out.println(wordPlan.toString());
    }
}
