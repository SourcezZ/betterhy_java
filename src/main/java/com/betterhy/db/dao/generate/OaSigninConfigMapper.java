package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaSigninConfig;
import com.betterhy.db.dto.OaSigninConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSigninConfigMapper {
    long countByExample(OaSigninConfigExample example);

    int deleteByExample(OaSigninConfigExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(OaSigninConfig record);

    int insertSelective(OaSigninConfig record);

    List<OaSigninConfig> selectByExample(OaSigninConfigExample example);

    OaSigninConfig selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") OaSigninConfig record, @Param("example") OaSigninConfigExample example);

    int updateByExample(@Param("record") OaSigninConfig record, @Param("example") OaSigninConfigExample example);

    int updateByPrimaryKeySelective(OaSigninConfig record);

    int updateByPrimaryKey(OaSigninConfig record);
}