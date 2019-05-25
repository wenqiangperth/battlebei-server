package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.*;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordService
 * @Description TODO
 * @Date 2019/5/16 13:45
 **/
@Service
public class WordService {
    @Autowired
    private WordCet4Dao wordCet4Dao;
    @Autowired
    private WordCet6Dao wordCet6Dao;
    @Autowired
    private WordieltsDao wordieltsDao;
    @Autowired
    private WordToeflDao wordToeflDao;
    @Autowired
    private WordPlanDao wordPlanDao;
    @Autowired
    private WordDao wordDao;


    /**
     * 获得用户现在要的学习词汇
     * @param openId
     * @return
     */
    public ArrayList<Word>getStudyWords(String openId){
        WordPlan wordPlan=wordPlanDao.getNowWordPlan(openId);
        if(wordPlan==null){
            return null;
        }
        if(wordPlan.getCategory().equals(Constant.CET4)){
            return wordDao.getCet4Words(wordPlan.getPace(),wordPlan.getPace()+wordPlan.getDailyNum());
        }else if(wordPlan.getCategory().equals(Constant.CET6)){
            return wordDao.getCet6Words(wordPlan.getPace(),wordPlan.getPace()+wordPlan.getDailyNum());
        }else if(wordPlan.getCategory().equals(Constant.IELTS)){
            return wordDao.getieltsWords(wordPlan.getPace(),wordPlan.getPace()+wordPlan.getDailyNum());
        }else if(wordPlan.getCategory().equals(Constant.TOEFL)){
            return wordDao.getToeflWords(wordPlan.getPace(),wordPlan.getPace()+wordPlan.getDailyNum());
        }else{
            return null;
        }
    }


    /**
     * 查询计划中剩余单词量
     * @param wordPlan
     * @return
     */
    public Long getRemaining(WordPlan wordPlan){
        if(wordPlan.getCategory().equals(Constant.CET4)){
            return wordCet4Dao.getRemaining(wordPlan.getPace());
        }else if(wordPlan.getCategory().equals(Constant.CET6)){
            return wordCet6Dao.getRemaining(wordPlan.getPace());
        }else if(wordPlan.getCategory().equals(Constant.IELTS)){
            return wordieltsDao.getRemaining(wordPlan.getPace());
        }else if(wordPlan.getCategory().equals(Constant.TOEFL)){
            return wordToeflDao.getRemaining(wordPlan.getPace());
        }else{
            return null;
        }
    }
}
