package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.mapper.UserTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName UserTestWordDao
 * @Description TODO
 * @Date 2019/5/27 8:40
 **/
@Repository
public class UserTestWordDao {
    @Autowired
    private UserTestMapper userTestMapper;

    /**
     * 删除user_test表中用户正确的单词
     * @param userWord
     * @return
     */
    public Long deleteUserTestWordRight(UserWord userWord){
        return userTestMapper.deleteUserTestWordRight(userWord);
    }


}
