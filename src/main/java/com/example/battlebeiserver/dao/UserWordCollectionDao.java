package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.mapper.WordCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserWordCollectionDao
 * @Description TODO
 * @Date 2019/5/27 15:49
 **/
@Repository
public class UserWordCollectionDao {
    @Autowired
    private WordCollectionMapper wordCollectionMapper;

    /**
     * 添加生词本
     * @param userWord
     * @return
     */
    public Long addWordCollection(UserWord userWord){
        return wordCollectionMapper.addWordCollection(userWord);
    }

    /**
     * 用户删除生词本某个单词
     * @param userWord
     * @return
     */
    public Long deleteWordCollectionByOpenIdAndWordId(UserWord userWord){
        return wordCollectionMapper.deleteWordCollectionByOpenIdAndWordId(userWord);
    }

    /**
     * 获得用户生词本
     * @param openId
     * @return
     */
    public ArrayList<Word> getUserWordCollection(String openId){
        return wordCollectionMapper.getUserWordCollection(openId);
    }
}
