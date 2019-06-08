package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName WordCollectionMapper
 * @Description TODO
 * @Date 2019/5/27 15:45
 **/
@Mapper
@Repository
public interface WordCollectionMapper {

    /**
     * 添加生词本
     * @param userWord
     * @return
     */
    @Insert("insert into user_word_collection (open_id,word_id) values (#{openId},#{wordId})")
    public Long addWordCollection(UserWord userWord);

    /**
     * 用户删除生词本某个单词
     * @param userWord
     * @return
     */
    @Delete("delete from user_word_collection where open_id=#{openId} and word_id=#{wordId}")
    public Long deleteWordCollectionByOpenIdAndWordId(UserWord userWord);

    /**
     * 获得用户生词本
     * @param openId
     * @return
     */
    @Select("select w.id,w.word from word w,user_word_collection uwc where uwc.open_id=#{openId} and uwc.word_id=w.id")
    public ArrayList<Word>getUserWordCollection(@Param(value = "openId")String openId);


    /**
     * 获得用户battle所需生词
     * @param openId
     * @param battleNum
     * @return
     */
    @Select("select w.id,w.word from word w,user_word_collection uwc where uwc.open_id=#{openId} " +
            "and uwc.word_id=w.id and uwc.id>=(select floor(rand()*((select max(id) from user_word_collection)" +
            "-(select min(id) from user_word_collection))+(select min(id) from user_word_collection)))" +
            "order by uwc.id limit #{battleNum}")
    public ArrayList<Word>getUserWordCollectionForBattle(@Param(value = "openId")String openId,@Param(value = "battleNum")Long battleNum);

    /**
     * 判断该词是否在collection表
     * @param openId
     * @param wordId
     * @return
     */
    @Select("select id from user_word_collection where open_id=#{openId} and word_id=#{wordId}")
    public Long iswordinCollection(@Param(value = "openId")String openId,@Param(value = "wordId")Long wordId);
}
