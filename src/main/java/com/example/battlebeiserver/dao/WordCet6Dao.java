package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.mapper.WordCet6Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordCet6Dao
 * @Description TODO
 * @Date 2019/5/16 14:14
 **/@Repository
public class WordCet6Dao {
     @Autowired
     private WordCet6Mapper wordCet6Mapper;

    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    public Long getRemaining(Long pace){
        return wordCet6Mapper.getRemaining(pace);
    }
}
