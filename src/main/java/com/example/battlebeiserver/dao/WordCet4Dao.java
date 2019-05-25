package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.mapper.WordCet4Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordCet4Dao
 * @Description TODO
 * @Date 2019/5/16 14:03
 **/
@Repository
public class WordCet4Dao {
    @Autowired
    private WordCet4Mapper wordCet4Mapper;


    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    public Long getRemaining(Long pace){
        return wordCet4Mapper.getRemaining(pace);
    }

}
