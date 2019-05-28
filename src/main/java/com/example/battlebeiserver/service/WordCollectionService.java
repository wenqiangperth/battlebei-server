package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.UserWordCollectionDao;
import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordCollectionService
 * @Description TODO
 * @Date 2019/5/27 15:44
 **/
@Service
public class WordCollectionService {
    @Autowired
    private UserWordCollectionDao userWordCollectionDao;

    /**
     * 添加生词本
     * @param userWord
     * @return
     */
    public Long addWordCollection(UserWord userWord){
        return userWordCollectionDao.addWordCollection(userWord);
    }

    /**
     * 用户删除生词本某个单词
     * @param userWord
     * @return
     */
    public Long deleteWordCollectionByOpenIdAndWordId(UserWord userWord){
        return userWordCollectionDao.deleteWordCollectionByOpenIdAndWordId(userWord);
    }

    /**
     * 获得用户生词本
     * @param openId
     * @return
     */
    public ArrayList<Word> getUserWordCollection(String openId){
        return userWordCollectionDao.getUserWordCollection(openId);
    }
}
