package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.service.WordService;
import com.example.battlebeiserver.service.WordTestService;
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
    @Autowired
    private WordTestService wordTestService;

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

    /**
     * 用户认识该词，当前用户进度++ 参数openId,wordId
     * @param userWord
     * @return
     */
    @PutMapping(value = "/knownword")
    public Long handleStudyKnownWord(@RequestBody UserWord userWord){
        return wordService.handleStudyKnownWord(userWord);
    }

    /**
     * 处理学习过程中不认识的单词，更新进度，同时加入user_test、user_word表 参数openId,wordId
     * @param userWord
     * @return
     */
    @PutMapping(value = "/unknownword")
    public Long handleStudyUnknownWord(@RequestBody UserWord userWord){
        return wordService.handleStudyUnknownWord(userWord);
    }

    /**
     * 查询用户学习过程中的小测单词列表
     * @param openId
     * @return
     */
    @GetMapping(value = "/testword")
    public ArrayList<Word> getUserTestWord(@RequestParam(name = "openId") String openId){
        return wordService.getUserTestWord(openId);
    }

    /**
     * 处理用户学习过程中小测正确的单词 参数openId,wordId
     * @param userWord
     * @return
     */
    @PutMapping(value = "/righttestword")
    public Long setUserTestWordRight(@RequestBody UserWord userWord){
        return wordTestService.setUserTestWordRight(userWord);
    }

    /**
     * 处理用户学习过程中小测错误的单词 参数openId,wordId
     * @param userWord
     * @return
     */
    @PutMapping(value = "/wrongtestword")
    public Long setUserTestWordWrong(@RequestBody UserWord userWord){
        return wordTestService.setUserTestWordWrong(userWord);
    }

}
