package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordMapper
 * @Description TODO
 * @Date 2019/5/14 9:39
 **/
@Mapper
@Repository
public interface WordMapper {


    /**
     * 查询cet4表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    @Select("select w.id ,w.word from word w,word_cet4 w4 where w4.id>=#{pace} and w4.id<#{end} and w.id=w4.word_id")
    public ArrayList<Word> getCet4Words(@Param("pace") Long pace,@Param("end") Long end);

    /**
     * 查询cet6表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    @Select("select w.id ,w.word from word w,word_cet6 w6 where w6.id>=#{pace} and w6.id<#{end} and w.id=w6.word_id")
    public ArrayList<Word> getCet6Words(@Param("pace") Long pace,@Param("end") Long end);

    /**
     * 查询ielts表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    @Select("select w.id ,w.word from word w,word_ielts wi where wi.id>=#{pace} and wi.id<#{end} and w.id=wi.word_id")
    public ArrayList<Word> getieltsWords(@Param("pace") Long pace,@Param("end") Long end);

    /**
     * 查询toefl表的应该学习的单词list
     * @param pace
     * @param end
     * @return
     */
    @Select("select w.id ,w.word from word w,word_toefl wt where wt.id>=#{pace} and wt.id<#{end} and w.id=wt.word_id")
    public ArrayList<Word> getToeflWords(@Param("pace") Long pace,@Param("end") Long end);


}
