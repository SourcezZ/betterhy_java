package com.betterhy.common.db.dao.generate;

import com.betterhy.common.db.dto.OaUserRank;
import com.betterhy.common.db.dto.OaUserRankExample;
import com.betterhy.common.db.dto.OaUserRankKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaUserRankMapper {
    long countByExample(OaUserRankExample example);

    int deleteByExample(OaUserRankExample example);

    int deleteByPrimaryKey(OaUserRankKey key);

    int insert(OaUserRank record);

    int insertSelective(OaUserRank record);

    List<OaUserRank> selectByExample(OaUserRankExample example);

    OaUserRank selectByPrimaryKey(OaUserRankKey key);

    int updateByExampleSelective(@Param("record") OaUserRank record, @Param("example") OaUserRankExample example);

    int updateByExample(@Param("record") OaUserRank record, @Param("example") OaUserRankExample example);

    int updateByPrimaryKeySelective(OaUserRank record);

    int updateByPrimaryKey(OaUserRank record);
}