package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.mapper.WordToeflMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordToeflDao
 * @Description TODO
 * @Date 2019/5/16 14:16
 **/
@Repository
public class WordToeflDao {
    @Autowired
    private WordToeflMapper wordToeflMapper;

    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    public Long getRemaining(Long pace){
        return wordToeflMapper.getRemaining(pace);
    }


}
