package com.example.battlebeiserver.mapper;


import com.example.battlebeiserver.entity.UserWord;
import com.example.battlebeiserver.entity.WordPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author perth
 * @ClassName WordPlanMapper
 * @Description TODO
 * @Date 2019/5/14 9:18
 **/
@Mapper
@Repository
public interface WordPlanMapper {

    /**
     * 获得用户当前的单词计划
     * @param openId
     * @param presentFlag
     * @return
     */
    @Select("select * from user_word_plan where open_id=#{openId} and present_flag=#{presentFlag}")
    @Results(id="wordPlanMap",value = {
            @Result(property = "openId",column = "open_id"),
            @Result(property = "category",column = "category"),
            @Result(property = "dailyNum",column = "daily_num"),
            @Result(property = "pace",column = "pace"),
            @Result(property = "presentFlag",column = "present_flag"),
            @Result(property = "startDate",column = "start_date"),
            @Result(property = "endDate",column = "end_date")
    })
    public WordPlan getNowWordPlan(@Param("openId")String openId,@Param("presentFlag")boolean presentFlag);


    /**
     * 根据openId,category查询wordplan
     * @param wordPlan
     * @return
     */
    @Select("select * from user_word_plan where open_id=#{openId} and category=#{category}")
    @ResultMap(value = "wordPlanMap")
    public WordPlan getWordPlanByOpenIdAndCategory(WordPlan wordPlan);

    /**
     * 设置当前计划的单词量
     * @param wordPlan
     * @return
     */
    @Update("update user_word_plan set daily_num=#{dailyNum} where open_id=#{openId} and present_flag=#{presentFlag}")
    public Long setWordPlanDailyNum(WordPlan wordPlan);

    /**
     * 更新用户计划，设置xx为当前计划
     * @param wordPlan
     * @return
     */
    @Update("update user_word_plan set daily_num=#{dailyNum},end_date=#{endDate},present_flag=#{presentFlag} where open_id=#{openId} and category=#{category}")
    public Long setNowWordPlan(WordPlan wordPlan);

    /**
     * 设置用户当前计划为不是当前计划
     * @param openId
     * @param oldPresentFlag
     * @param nowPresentFlag
     * @return
     */
    @Update("update user_word_plan set present_flag=#{nowPresentFlag} where open_id=#{openId} and present_flag=#{oldPresentFlag}")
    public Long setWordPlanPresent(@Param("openId")String openId,@Param("oldPresentFlag")Boolean oldPresentFlag,@Param("nowPresentFlag")Boolean nowPresentFlag);

    /**
     * 添加用户计划
     * @param wordPlan
     */
    @Insert("insert into user_word_plan(open_id,category,daily_num,pace,present_flag,start_date,end_date) values (#{openId},#{category},#{dailyNum},#{pace},#{presentFlag},#{startDate},#{endDate})")
    public Long addWordPlan(WordPlan wordPlan);

    /**
     * 用户当前计划进度++
     * @param userWord
     * @return
     */
    @Update("update user_word_plan set pace=pace+1 where open_id=#{openId} and present_flag=true")
    public Long setNowWordPlanPace(UserWord userWord);

}
