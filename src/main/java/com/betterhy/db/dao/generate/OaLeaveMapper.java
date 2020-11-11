package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaLeave;
import com.betterhy.db.dto.OaLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaLeaveMapper {
    long countByExample(OaLeaveExample example);

    int deleteByExample(OaLeaveExample example);

    int deleteByPrimaryKey(Long leaveId);

    int insert(OaLeave record);

    int insertSelective(OaLeave record);

    List<OaLeave> selectByExample(OaLeaveExample example);

    OaLeave selectByPrimaryKey(Long leaveId);

    int updateByExampleSelective(@Param("record") OaLeave record, @Param("example") OaLeaveExample example);

    int updateByExample(@Param("record") OaLeave record, @Param("example") OaLeaveExample example);

    int updateByPrimaryKeySelective(OaLeave record);

    int updateByPrimaryKey(OaLeave record);
}