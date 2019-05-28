package com.example.battlebeiserver.dao;

import com.example.battlebeiserver.entity.Battle;
import com.example.battlebeiserver.entity.BattleGrade;
import com.example.battlebeiserver.entity.Word;
import com.example.battlebeiserver.mapper.BattleMapper;
import com.example.battlebeiserver.mapper.WordCollectionMapper;
import com.example.battlebeiserver.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName BattleDao
 * @Description TODO
 * @Date 2019/5/27 18:12
 **/
@Repository
public class BattleDao {
    @Autowired
    private BattleMapper battleMapper;
    @Autowired
    private WordCollectionMapper wordCollectionMapper;

    /**
     * 增加新的battle
     * @param battle
     * @return
     */
    public Long addUserBattle(Battle battle){
        return battleMapper.addUserBattle(battle);
    }

    /**
     * 根据id设置battle分数,并将分数加到用户battle_grade里
     * @param battle
     * @return
     */
    @Transactional
    public Long setUserBattleGrade(Battle battle){
        Long temp=battleMapper.addUserBattleGrade(battle.getStartOpenId(),battle.getGrade());
        if(temp<=0){
            temp=battleMapper.insertUserBattle(battle.getStartOpenId(),battle.getGrade());
        }
        return temp*battleMapper.setUserBattleGrade(battle);
    }

    /**
     * 获得battle所需词汇
     * @param openId
     * @return
     */
    public ArrayList<Word> getBattleWords(String openId){
        return wordCollectionMapper.getUserWordCollectionForBattle(openId, Constant.BATTLENUM);
    }

    /**
     * 获得所有用户的battle成绩
     * @return
     */
    public ArrayList<BattleGrade>getUserBattleGrades(){
        return battleMapper.getUserBattleGrades();
    }

}
