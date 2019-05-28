package com.example.battlebeiserver.mapper;

import com.example.battlebeiserver.entity.Battle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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

    @Update("update battle set grade=#{grade} where id=#{id}")
    public Long setUserBattleGrade(Battle battle);
}
