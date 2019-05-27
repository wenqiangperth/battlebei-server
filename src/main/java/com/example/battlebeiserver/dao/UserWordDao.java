package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.mapper.UserTestMapper;
import com.example.battlebeiserver.mapper.UserWordMapper;
import com.example.battlebeiserver.mapper.WordPlanMapper;
import com.example.battlebeiserver.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserWordDao
 * @Description TODO
 * @Date 2019/5/26 22:53
 **/
@Repository
public class UserWordDao {
    @Autowired
    private UserWordMapper userWordMapper;
    @Autowired
    private WordPlanMapper wordPlanMapper;
    @Autowired
    private UserTestMapper userTestMapper;

    /**
     * 处理学习过程中不认识的单词，更新进度，同时加入user_test、user_word表
     * @param userWord
     * @return
     */
    @Transactional
    public Long handleUnknownWord(UserWord userWord){
        Long pace=wordPlanMapper.setNowWordPlanPace(userWord);
        Long unknown=userWordMapper.addUnknownWord(userWord);
        Long test=userTestMapper.addUserTestWord(userWord);
        return pace*unknown*test;
    }

    /**
     * 查询用户学习过程中的小测单词列表
     * @param openId
     * @return
     */
    public ArrayList<Word> getUserTestWord(String openId){
        return userTestMapper.getUserTestWord(openId);
    }

    /**
     * 更新用户单词的权重
     * @param userWord
     * @return
     */
    public Long setUserWordWeight(UserWord userWord){
        return userWordMapper.setUserWordWeight(userWord);
    }

    /**
     * 获得用户单词 根据用户id，单词id
     * @param userWord
     * @return
     */
    public UserWord getUserWordByOpenIdAndWordId(UserWord userWord){
        return userWordMapper.getUserWordByOpenIdAndWordId(userWord);
    }

    /**
     * 删除user_word表的一个单词
     * @param userWord
     * @return
     */
    public Long deleteUserWordByOpenIdAndWordId(UserWord userWord){
        return userWordMapper.deleteUserWordByOpenIdAndWordId(userWord);
    }

    /**
     * 获取用户复习的前number个词汇
     * @param openId
     * @return
     */
    public ArrayList<Word>getReviewWord(String openId){
        return userWordMapper.getReviewWord(openId, Constant.REVIEWNUM);
    }
}
