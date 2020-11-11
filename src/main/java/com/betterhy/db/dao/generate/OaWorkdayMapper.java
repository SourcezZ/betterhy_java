package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaWorkday;
import com.betterhy.db.dto.OaWorkdayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaWorkdayMapper {
    long countByExample(OaWorkdayExample example);

    int deleteByExample(OaWorkdayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OaWorkday record);

    int insertSelective(OaWorkday record);

    List<OaWorkday> selectByExample(OaWorkdayExample example);

    OaWorkday selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OaWorkday record, @Param("example") OaWorkdayExample example);

    int updateByExample(@Param("record") OaWorkday record, @Param("example") OaWorkdayExample example);

    int updateByPrimaryKeySelective(OaWorkday record);

    int updateByPrimaryKey(OaWorkday record);
}