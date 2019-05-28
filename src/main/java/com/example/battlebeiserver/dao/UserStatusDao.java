package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.UserStatus;
import com.example.battlebeiserver.entity.UserStudyStatus;
import com.example.battlebeiserver.mapper.UserStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author perth
 * @ClassName UserStatusDao
 * @Description TODO
 * @Date 2019/5/27 19:03
 **/
@Repository
public class UserStatusDao {
    @Autowired
    private UserStatusMapper userStatusMapper;

    /**
     * 用户学习量+1
     * @param userStatus
     * @return
     */
    public Long addUserStatusStudyNum(UserStatus userStatus){
        userStatus.setDate(new Date());
        Long temp=userStatusMapper.addUserStatusStudyNum(userStatus);
        if(temp>0){
            return temp;
        }else{
            userStatus.setStudyNum(1L);
            userStatus.setReviewNum(0L);
            return userStatusMapper.addUserStatus(userStatus);
        }
    }

    /**
     * 用户今日复习量+1
     * @param userStatus
     * @return
     */
    public Long addUserStatusReviewNum(UserStatus userStatus){
        userStatus.setDate(new Date());
        Long temp=userStatusMapper.addUserStatusReviewNum(userStatus);
        if(temp>0){
            return temp;
        }else{
            userStatus.setReviewNum(1L);
            userStatus.setStudyNum(0L);
            return userStatusMapper.addUserStatus(userStatus);
        }
    }

    /**
     * 获得用户今日学习量,复习量
     * @param openId
     * @return
     */
    public UserStudyStatus getUserTodayStudyNumAndReviewNum(String openId){
        return userStatusMapper.getUserTodayStudyNumAndReviewNum(openId,new Date());
    }

    /**
     * 获得所有用户总的学习单词量
     * @return
     */
    public ArrayList<UserStatus> getUserStudyNum(){
        return userStatusMapper.getUserStudyNum();
    }
}
