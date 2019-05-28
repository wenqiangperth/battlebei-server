package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.UserStatus;
import com.example.battlebeiserver.entity.UserStudyStatus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author perth
 * @ClassName UserStatusMapper
 * @Description TODO
 * @Date 2019/5/27 18:53
 **/
@Mapper
@Repository
public interface UserStatusMapper {


    /**
     * 用户今日学习词汇量+1
     * @param userStatus
     * @return
     */
    @Update("update user_status set study_num=study_num+1 where open_id=#{openId} and to_days(date)=to_days(#{date})")
    public Long addUserStatusStudyNum(UserStatus userStatus);

    /**
     * 增加用户今日学习记录
     * @param userStatus
     * @return
     */
    @Insert("insert into user_status (open_id,study_num,review_num,date) values(#{openId},#{studyNum},#{reviewNum},#{date})")
    public Long addUserStatus(UserStatus userStatus);

    /**
     * 用户今日复习量+1
     * @param userStatus
     * @return
     */
    @Update("update user_status set review_num=review_num+1 where open_id=#{openId} and to_days(date)=to_days(#{date})")
    public Long addUserStatusReviewNum(UserStatus userStatus);

    /**
     * 获得用户今日学习量,复习量
     * @param openId
     * @param date
     * @return
     */
    @Select("select study_num,review_num from user_status where open_id=#{openId} and to_days(date)=to_days(#{date})")
    @Results(value = {
            @Result(property = "todayStudyWordNum",column = "study_num"),
            @Result(property = "todayReviewWordNum",column = "review_num")
    })
    public UserStudyStatus getUserTodayStudyNumAndReviewNum(@Param(value = "openId")String openId, @Param(value = "date")Date date);

    /**
     * 获得所有用户总的学习单词量
     * @return
     */
    @Select("select open_id,sum(study_num) study_num from user_status group by open_id order by sum(study_num) desc")
    @Results(value = {
            @Result(property = "openId",column = "open_id"),
            @Result(property = "studyNum",column = "study_num")
    })
    public ArrayList<UserStatus> getUserStudyNum();

}
