package com.example.battlebeiserver.entity;

import lombok.Data;

/**
 * @author perth
 * @ClassName Battle
 * @Description TODO
 * @Date 2019/5/27 15:57
 **/
@Data
public class Battle {
    private Long id;
    private String startOpenId;
    private String receiveOpenId;
    private Long grade;
}
