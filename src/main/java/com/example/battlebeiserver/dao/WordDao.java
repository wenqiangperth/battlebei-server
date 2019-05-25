package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordDao
 * @Description TODO
 * @Date 2019/5/25 20:43
 **/
@Repository
public class WordDao {
    @Autowired
    private WordMapper wordMapper;

    /**
     * 查询cet4表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    public ArrayList<Word>getCet4Words(Long pace,Long end){
        return wordMapper.getCet4Words(pace,end);
    }

    /**
     * 查询cet6表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    public ArrayList<Word>getCet6Words(Long pace,Long end){
        return wordMapper.getCet6Words(pace,end);
    }

    /**
     * 查询ielts表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    public ArrayList<Word>getieltsWords(Long pace,Long end){
        return wordMapper.getieltsWords(pace,end);
    }

    /**
     * 查询Toefl表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    public ArrayList<Word>getToeflWords(Long pace,Long end){
        return wordMapper.getToeflWords(pace,end);
    }
}
