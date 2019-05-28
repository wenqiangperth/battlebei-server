package com.example.battlebeiserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author perth
 * @ClassName UserStatus
 * @Description TODO
 * @Date 2019/5/27 18:58
 **/
@Data
public class UserStatus {
    private String openId;
    private Long studyNum;
    private Long reviewNum;
    private Date date;
}
