package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserWord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
