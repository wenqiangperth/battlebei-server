package com.example.battlebeiserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordieltsMapper
 * @Description TODO
 * @Date 2019/5/16 14:13
 **/
@Mapper
@Repository
public interface WordieltsMapper {

    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    @Select("select count(id) from word_ielts where id>=#{pace}")
    public Long getRemaining(@Param("pace") Long pace);
}
