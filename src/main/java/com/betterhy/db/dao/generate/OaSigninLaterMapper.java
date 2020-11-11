package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaSigninLater;
import com.betterhy.db.dto.OaSigninLaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSigninLaterMapper {
    long countByExample(OaSigninLaterExample example);

    int deleteByExample(OaSigninLaterExample example);

    int deleteByPrimaryKey(Long signinLaterId);

    int insert(OaSigninLater record);

    int insertSelective(OaSigninLater record);

    List<OaSigninLater> selectByExample(OaSigninLaterExample example);

    OaSigninLater selectByPrimaryKey(Long signinLaterId);

    int updateByExampleSelective(@Param("record") OaSigninLater record, @Param("example") OaSigninLaterExample example);

    int updateByExample(@Param("record") OaSigninLater record, @Param("example") OaSigninLaterExample example);

    int updateByPrimaryKeySelective(OaSigninLater record);

    int updateByPrimaryKey(OaSigninLater record);
}