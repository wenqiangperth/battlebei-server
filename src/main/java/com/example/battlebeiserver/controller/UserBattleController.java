package com.example.battlebeiserver.controller;

import com.example.battlebeiserver.entity.Battle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perth
 * @ClassName UserBattleController
 * @Description TODO
 * @Date 2019/5/27 15:56
 **/
@RestController
public class UserBattleController {

    /**
     *
     * @param battle
     * @return
     */
    @PostMapping(value = "battle")
    public Long addUserBattle(@RequestBody Battle battle){

    }
}
