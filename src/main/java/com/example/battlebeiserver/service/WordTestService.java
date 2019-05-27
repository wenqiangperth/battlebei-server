package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.UserTestWordDao;
import com.example.battlebeiserver.dao.UserWordDao;
import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

/**
 * @author perth
 * @ClassName WordTestService
 * @Description TODO
 * @Date 2019/5/26 23:27
 **/
@Service
public class WordTestService {
    @Autowired
    private UserWordDao userWordDao;
    @Autowired
    private UserTestWordDao userTestWordDao;

    /**
     * 处理用户学习过程中小测正确的单词
     * @param userWord
     * @return
     */
    public Long setUserTestWordRight(UserWord userWord){
        Long temp=improveUserWordWeight(userWord);
        Long te=userTestWordDao.deleteUserTestWordRight(userWord);
        return te*temp;
    }

    /**
     * 处理用户学习过程中小测错误的单词
     * @param userWord
     * @return
     */
    public Long setUserTestWordWrong(UserWord userWord){
        return reduceUserWordWeight(userWord);
    }

    /**
     * 处理一个提升weight的单词，++或者满了删除
     * @param userWord
     * @return
     */
    public Long improveUserWordWeight(UserWord userWord){
        UserWord userWord1=userWordDao.getUserWordByOpenIdAndWordId(userWord);
        Long temp=0L;
        if(userWord1.getWeight()< Constant.BIGWEIGHT){
            userWord1.setWeight(userWord1.getWeight()+1);
            userWord1.setDate(new Date());
            temp=userWordDao.setUserWordWeight(userWord1);
        }else{
            temp=userWordDao.deleteUserWordByOpenIdAndWordId(userWord1);
        }
        return temp;
    }

    /**
     * 处理一个降低weight的单词，--
     * @param userWord
     * @return
     */
    public Long reduceUserWordWeight(UserWord userWord){
        UserWord userWord1=userWordDao.getUserWordByOpenIdAndWordId(userWord);
        Long temp=0L;
        userWord1.setDate(new Date());
        if(userWord1.getWeight()>Constant.SMALLWEIGTH){
            userWord1.setWeight(userWord1.getWeight()-1);
            temp=userWordDao.setUserWordWeight(userWord);
        }else{
            temp=userWordDao.setUserWordWeight(userWord);
        }
        return temp;
    }
}
