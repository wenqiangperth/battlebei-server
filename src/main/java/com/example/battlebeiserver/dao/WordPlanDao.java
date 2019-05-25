package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.mapper.WordPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author perth
 * @ClassName WordPlanDao
 * @Description TODO
 * @Date 2019/5/16 12:38
 **/
@Repository
public class WordPlanDao {
    @Autowired
    private WordPlanMapper wordPlanMapper;


    public WordPlan getNowWordPlan(String openId){
        return wordPlanMapper.getNowWordPlan(openId,true);
    }

    /**
     * openId,category查询用户计划是否存在
     * @param wordPlan
     * @return
     */
    public WordPlan getWordPlanByOpenIdAndCategory(WordPlan wordPlan){
        return wordPlanMapper.getWordPlanByOpenIdAndCategory(wordPlan);
    }

    /**
     * 新增计划
     * @param wordPlan
     * @return
     */
    public Long addWordPlan(WordPlan wordPlan){
        wordPlanMapper.setWordPlanPresent(wordPlan.getOpenId(),Boolean.TRUE,Boolean.FALSE);
        return wordPlanMapper.addWordPlan(wordPlan);
    }

    /**
     * 设置用户当前计划的单词量
     * @param wordPlan
     * @return
     */
    public Long setWordPlanDailyNum(WordPlan wordPlan){
        return wordPlanMapper.setWordPlanDailyNum(wordPlan);
    }

    /**
     * 更改用户计划为当前计划
     * @param wordPlan
     * @return
     */
    @Transactional
    public Long setNowWordPlan(WordPlan wordPlan){
        wordPlanMapper.setWordPlanPresent(wordPlan.getOpenId(),Boolean.TRUE,Boolean.FALSE);
        return wordPlanMapper.setNowWordPlan(wordPlan);

    }
}
