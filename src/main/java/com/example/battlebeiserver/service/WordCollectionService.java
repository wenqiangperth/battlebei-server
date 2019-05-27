package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.UserWordCollectionDao;
import com.example.battlebeiserver.entity.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
