package com.example.battlebeiserver.entity;

import lombok.Data;

/**
 * @author perth
 * @ClassName UserStudyStatus
 * @Description TODO
 * @Date 2019/5/27 20:30
 **/
@Data
public class UserStudyStatus {
    private String openId;
    private int wordLeftDays;
    private int todayStudyWordNum;
    private int dailyNum;
    private int todayReviewWordNum;
    private int reviewNum;
}
