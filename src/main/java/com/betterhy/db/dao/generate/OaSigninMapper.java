package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaSigninMapper {
    long countByExample(OaSigninExample example);

    int deleteByExample(OaSigninExample example);

    int deleteByPrimaryKey(Long signinId);

    int insert(OaSignin record);

    int insertSelective(OaSignin record);

    List<OaSignin> selectByExample(OaSigninExample example);

    OaSignin selectByPrimaryKey(Long signinId);

    int updateByExampleSelective(@Param("record") OaSignin record, @Param("example") OaSigninExample example);

    int updateByExample(@Param("record") OaSignin record, @Param("example") OaSigninExample example);

    int updateByPrimaryKeySelective(OaSignin record);

    int updateByPrimaryKey(OaSignin record);
}