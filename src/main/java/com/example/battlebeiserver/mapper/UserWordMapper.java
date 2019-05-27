package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserWordMapper
 * @Description TODO
 * @Date 2019/5/26 22:40
 **/
@Mapper
@Repository
public interface UserWordMapper {

    /**
     * 增加用户学习时候不认识的词汇
     * @param userWord
     * @return
     */
    @Insert("insert into user_word (open_id,word_id,weight,date) values (#{openId},#{wordId},#{weight},#{date})")
    public Long addUnknownWord(UserWord userWord);

    /**
     * 更新用户单词的权重
     * @param userWord
     * @return
     */
    @Update("update user_word set weight=#{weight},date=#{date} where open_id=#{openId} and word_id=#{wordId}")
    public Long setUserWordWeight(UserWord userWord);

    /**
     * 获得用户单词 根据用户id，单词id
     * @param userWord
     * @return
     */
    @Select("select * from user_word where open_id=#{openId} and word_id=#{wordId}")
    @Results(id="userWordMap",value = {
            @Result(property = "openId",column = "open_id"),
            @Result(property = "wordId",column = "word_id"),
            @Result(property = "weight",column = "weight"),
            @Result(property = "date",column = "date")
    })
    public UserWord getUserWordByOpenIdAndWordId(UserWord userWord);

    /**
     * 删除user_word的一个词汇
     * @param userWord
     * @return
     */
    @Delete("delete from user_word where open_id=#{openId} and word_id=#{wordId}")
    public Long deleteUserWordByOpenIdAndWordId(UserWord userWord);

    /**
     * 获取用户复习的前number个词汇
     * @param openId
     * @param number
     * @return
     */
    @Select("select w.id,w.word from user_word uw,word w where uw.open_id=#{openId} and uw.word_id=w.id order by uw.date limit #{number}")
    public ArrayList<Word>getReviewWord(@Param(value = "openId")String openId,@Param(value = "number")Long number);

}
