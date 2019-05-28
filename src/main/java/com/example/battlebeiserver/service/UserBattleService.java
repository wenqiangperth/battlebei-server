package com.example.battlebeiserver.service;

import com.example.battlebeiserver.dao.BattleDao;
import com.example.battlebeiserver.entity.Battle;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName UserBattleService
 * @Description TODO
 * @Date 2019/5/27 18:33
 **/
@Service
public class UserBattleService {
    @Autowired
    private BattleDao battleDao;

    /**
     * 增加用户battle
     * @param battle
     * @return
     */
    public Long addUserBattle(Battle battle){
        return battleDao.addUserBattle(battle);
    }

    /**
     * 设置某次battle的成绩
     * @param battle
     * @return
     */
    public Long setUserBattleGrade(Battle battle){
        battle.setGrade(battle.getRightNum()/ Constant.BATTLEGRADENUM);
        return battleDao.setUserBattleGrade(battle);
    }

    /**
     * 获得battle所需词汇
     * @param openId
     * @return
     */
    public ArrayList<Word> getBattleWords(String openId){
        return battleDao.getBattleWords(openId);
    }
}
