package com.example.battlebeiserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author perth
 * @ClassName WordPlan
 * @Description TODO
 * @Date 2019/5/14 8:44
 * @Version 1.0
 **/
@Data
public class WordPlan {
    private String openId;
    private String category;
    private Long dailyNum;
    private Long pace;
    private Boolean presentFlag;
    private Date startDate;
    private Date endDate;
}
