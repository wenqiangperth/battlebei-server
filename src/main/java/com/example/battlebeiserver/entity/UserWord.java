package com.example.battlebeiserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author perth
 * @ClassName UserWord
 * @Description TODO
 * @Date 2019/5/25 21:54
 **/
@Data
public class UserWord {
    private String openId;
    /**
     * wordId,总表的id
     */
    private Long wordId;
    private int weight;
    private Date date;
}
