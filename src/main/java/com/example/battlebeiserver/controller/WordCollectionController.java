package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.service.WordCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
