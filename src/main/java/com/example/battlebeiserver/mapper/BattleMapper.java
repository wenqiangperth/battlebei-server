package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.Battle;
import com.example.battlebeiserver.entity.BattleGrade;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author perth
 * @ClassName BattleMapper
 * @Description TODO
 * @Date 2019/5/27 16:03
 **/
@Mapper
@Repository
public interface BattleMapper {

    /**
     * 增加新的battle
     * @param battle
     * @return
     */
    @Insert("insert into battle (start_open_id,receive_open_id) values(#{startOpenId},#{receiveOpenId})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public Long addUserBattle(Battle battle);

    /**
     * 设置某次battle的成绩
     * @param battle
     * @return
     */
    @Update("update battle set grade=#{grade} where id=#{id}")
    public Long setUserBattleGrade(Battle battle);

    /**
     * 添加用户的battle成绩+某次battle分数
     * @param openId
     * @param score
     * @return
     */
    @Update("update battle_grade set grade=grade+#{score} where open_id=#{openId}")
    public Long addUserBattleGrade(@Param(value = "openId")String openId,@Param(value = "score")Long score);

    /**
     * 增加用户battle_grade记录
     * @param openId
     * @param score
     * @return
     */
    @Insert("insert into battle_grade (open_id,grade) values (#{openId},#{score})")
    public Long insertUserBattle(@Param(value = "openId")String openId,@Param(value = "score")Long score);

    /**
     * 获得所有用户的battle成绩
     * @return
     */
    @Select("select * from battle_grade order by grade desc")
    @Results(value = {
            @Result(property = "openId",column = "open_id"),
            @Result(property = "grade",column = "grade")
    })
    public ArrayList<BattleGrade> getUserBattleGrades();

}
