package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.Battle;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.service.UserBattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserBattleController
 * @Description TODO
 * @Date 2019/5/27 15:56
 **/
@RestController
public class UserBattleController {
    @Autowired
    private UserBattleService userBattleService;

    /**
     * 增加用户新的battle,返回该battle的id
     * @param battle
     * @return
     */
    @PostMapping(value = "/battle")
    public Long addUserBattle(@RequestBody Battle battle){
        return userBattleService.addUserBattle(battle);
    }

    /**
     * battle打分，包含battle的id,rightNum
     * @param battle
     * @return
     */
    @PutMapping(value = "/battlegrade")
    public Long setUserBattleGrade(@RequestBody Battle battle){
        return userBattleService.setUserBattleGrade(battle);
    }

    /**
     * 获得battle所需词汇
     * @param openId
     * @return
     */
    @GetMapping(value = "/battlewords")
    public ArrayList<Word>getBattleWords(@RequestParam(value = "openId")String openId){
        return userBattleService.getBattleWords(openId);
    }

}
