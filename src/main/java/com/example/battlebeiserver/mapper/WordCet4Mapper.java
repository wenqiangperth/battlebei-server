package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.WordPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordCet4Mapper
 * @Description TODO
 * @Date 2019/5/16 14:00
 **/
@Mapper
@Repository
public interface WordCet4Mapper {


    /**
     * 查询剩余单词量
     * @param pace
     * @return
     */
    @Select("select count(id) from word_cet4 where id>=#{pace}")
    public Long getRemaining(@Param("pace") Long pace);
}
