package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserTestMapper
 * @Description TODO
 * @Date 2019/5/26 23:00
 **/
@Mapper
@Repository
public interface UserTestMapper {

    /**
     * 增加用户学习过程中的小测单词
     * @param userWord
     * @return
     */
    @Insert("insert into user_word (open_id,word_id) values (#{openId},#{wordId})")
    public Long addUserTestWord(UserWord userWord);

    /**
     * 查询用户学习过程中的小测单词列表
     * @param openId
     * @return
     */
    @Select("select w.id,w.word from user_test ut,word w where ut.open_id=#{openId} and ut.word_id=w.id")
    public ArrayList<Word>getUserTestWord(@Param(value = "openId") String openId);

    /**
     * 删除user_test表中用户正确的单词
     * @param userWord
     * @return
     */
    @Delete("delete from user_test where open_id=#{openId} and word_id=#{wordId}")
    public Long deleteUserTestWordRight(UserWord userWord);
}
