package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.mapper.WordieltsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordieltsDao
 * @Description TODO
 * @Date 2019/5/16 14:15
 **/
@Repository
public class WordieltsDao {
    @Autowired
    private WordieltsMapper wordieltsMapper;


    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    public Long getRemaining(Long pace){
        return wordieltsMapper.getRemaining(pace);
    }


}
