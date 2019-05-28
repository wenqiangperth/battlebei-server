package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.service.WordCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordCollectionController
 * @Description TODO
 * @Date 2019/5/27 15:42
 **/
@RestController
public class WordCollectionController {
    @Autowired
    private WordCollectionService wordCollectionService;


    /**
     * 添加生词本
     * @param userWord
     * @return
     */
    @PostMapping(value = "/wordcollection")
    public Long addUserWordCollection(@RequestBody UserWord userWord){
        return wordCollectionService.addWordCollection(userWord);
    }

    /**
     * 用户删除生词本的某个词汇
     * @param userWord
     * @return
     */
    @DeleteMapping(value = "/wordcollection")
    public Long deleteUserWordCollection(@RequestBody UserWord userWord){
        return wordCollectionService.deleteWordCollectionByOpenIdAndWordId(userWord);
    }

    /**
     * 获得用户生词本
     * @param openId
     * @return
     */
    @GetMapping(value = "/userwordcollection")
    public ArrayList<Word>getUserWordCollection(@RequestParam(value = "openId")String openId){
        return wordCollectionService.getUserWordCollection(openId);
    }
}
