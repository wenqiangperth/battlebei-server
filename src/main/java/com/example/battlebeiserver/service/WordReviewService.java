package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.UserStatusDao;
import com.example.battlebeiserver.dao.UserWordDao;
import com.example.battlebeiserver.entity.UserStatus;
import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordReviewService
 * @Description TODO
 * @Date 2019/5/27 10:24
 **/
@Service
public class WordReviewService {
    @Autowired
    private UserWordDao userWordDao;
    @Autowired
    private WordTestService wordTestService;
    @Autowired
    private UserStatusDao userStatusDao;

    /**
     * 获取用户复习的前number个词汇
     * @param openId
     * @return
     */
    public ArrayList<Word> getReviewWord(String openId){
        return userWordDao.getReviewWord(openId);
    }

    /**
     * 处理复习过程正确词汇，weight++
     * @param userWord
     * @return
     */
    public Long setUserReviewWordRight(UserWord userWord){
        UserStatus userStatus=new UserStatus();
        userStatus.setOpenId(userWord.getOpenId());
        Long temp=userStatusDao.addUserStatusReviewNum(userStatus);
        Long te=wordTestService.improveUserWordWeight(userWord);
        return te*temp;
    }

    /**
     * 处理复习过程正确词汇，weight--
     * @param userWord
     * @return
     */
    public Long setUserReviewWordWrong(UserWord userWord){
        UserStatus userStatus=new UserStatus();
        userStatus.setOpenId(userWord.getOpenId());
        Long temp=userStatusDao.addUserStatusReviewNum(userStatus);
        Long te=wordTestService.reduceUserWordWeight(userWord);
        return te*temp;
    }
}
