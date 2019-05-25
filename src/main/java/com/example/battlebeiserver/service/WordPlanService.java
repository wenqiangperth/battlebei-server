package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.WordPlanDao;
import com.example.battlebeiserver.entity.WordPlan;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author perth
 * @ClassName WordPlanService
 * @Description TODO
 * @Date 2019/5/16 12:35
 **/
@Service
public class WordPlanService {
    @Autowired
    private WordPlanDao wordPlanDao;
    @Autowired
    private WordService wordService;


    /**
     * 设置单词计划
     * 1、openid,presentFlag=true,dailyNum =》设置单词量
     * 2、设置新计划
     * 3、更新计划为当前计划
     * @param wordPlan
     * @return
     */
    public Long setWordPlan(WordPlan wordPlan){
        wordPlan.setPresentFlag(true);
        if(wordPlan.getCategory()==null&& wordPlan.getDailyNum()!=null){
            return setWordPlanDailyNum(wordPlan);
        }
        WordPlan w=wordPlanDao.getWordPlanByOpenIdAndCategory(wordPlan);
        if(w==null){
            return addWordPlan(wordPlan);
        }else{
            if(wordPlan.getDailyNum()==null){
                wordPlan.setDailyNum(w.getDailyNum());
            }
            wordPlan.setPace(w.getPace());
            return setNowWordPlan(wordPlan);
        }
    }

    /**
     * 新增单词计划
     * @param wordPlan
     * @return
     */
    public Long addWordPlan(WordPlan wordPlan){
        if(wordPlan.getDailyNum()==null){
            wordPlan.setDailyNum(Constant.DAILYNUM);
        }
        wordPlan.setPace(Constant.CET4START);
        Date date=new Date();
        wordPlan.setStartDate(date);
        Long num=wordService.getRemaining(wordPlan);
        Long days=num/wordPlan.getDailyNum();
        if(days*wordPlan.getDailyNum()<num){
            days++;
        }
        int daynum=days.intValue();
        System.out.println(num);
        System.out.println(days);
        wordPlan.setEndDate(plusDay(daynum));
        return wordPlanDao.addWordPlan(wordPlan);
    }

    /**
     * 设置用户计划为当前计划
     * @param wordPlan
     * @return
     */
    public Long setNowWordPlan(WordPlan wordPlan){
        wordPlan.setPresentFlag(true);
        Long num=wordService.getRemaining(wordPlan);
        Long days=num/wordPlan.getDailyNum();
        if(days*wordPlan.getDailyNum()<num){
            days++;
        }
        int daynum=days.intValue();
        wordPlan.setEndDate(plusDay(daynum));
        return wordPlanDao.setNowWordPlan(wordPlan);
    }

    /**
     * 设置用户当前计划单词量
     * @param wordPlan
     * @return
     */
    public Long setWordPlanDailyNum(WordPlan wordPlan){
        return wordPlanDao.setWordPlanDailyNum(wordPlan);
    }

    /**
     * 在当前日期加天数后的日期
     * @param num
     * @return
     */
    public static Date plusDay(int num) {
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);
        d = ca.getTime();
        System.out.println(d);
        return d;
    }
}
