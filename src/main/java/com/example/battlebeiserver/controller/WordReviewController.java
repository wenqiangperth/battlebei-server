package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.service.WordReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 *@ClassName WordReviewController
 *@Description TODO
 *@author perth
 *@Date 2019/5/16 12:25
 **/
@RestController
public class WordReviewController {
    @Autowired
    private WordReviewService wordReviewService;


    /**
     * 获取用户复习的前number个词汇
     * @param openId
     * @return
     */
    @GetMapping(value = "/reviewword")
    public ArrayList<Word> getReviewWord(@RequestParam(name = "openId")String openId){
        return wordReviewService.getReviewWord(openId);
    }

    /**
     * 处理复习过程正确词汇，weight++
     * @param userWord
     * @return
     */
    @PutMapping(value = "/rightreviewword")
    public Long setUserReviewWordRight(@RequestBody UserWord userWord){
        return wordReviewService.setUserReviewWordRight(userWord);
    }

    /**
     * 处理复习过程正确词汇，weight--
     * @param userWord
     * @return
     */
    @PutMapping(value = "/wrongreviewword")
    public Long setUserReviewWrong(@RequestBody UserWord userWord){
        return wordReviewService.setUserReviewWordWrong(userWord);
    }
}
