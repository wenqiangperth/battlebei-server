package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 *@ClassName WordStudyController
 *@Description TODO
 *@author perth
 *@Date 2019/5/16 12:24
 **/
@RestController
public class WordStudyController {
    @Autowired
    private WordService wordService;

    /**
     * 获得用户此刻应学习的词汇
     * @param openId
     * @return
     */
    @GetMapping(value = "/studywords")
    public ArrayList<Word>getStudyWords(@RequestParam(name = "openId")String openId){
        System.out.println(openId);
        return wordService.getStudyWords(openId);
    }
}
