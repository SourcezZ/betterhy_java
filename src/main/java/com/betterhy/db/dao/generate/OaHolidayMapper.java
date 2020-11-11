package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaHoliday;
import com.betterhy.db.dto.OaHolidayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaHolidayMapper {
    long countByExample(OaHolidayExample example);

    int deleteByExample(OaHolidayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OaHoliday record);

    int insertSelective(OaHoliday record);

    List<OaHoliday> selectByExample(OaHolidayExample example);

    OaHoliday selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OaHoliday record, @Param("example") OaHolidayExample example);

    int updateByExample(@Param("record") OaHoliday record, @Param("example") OaHolidayExample example);

    int updateByPrimaryKeySelective(OaHoliday record);

    int updateByPrimaryKey(OaHoliday record);
}