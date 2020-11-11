package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaRank;
import com.betterhy.db.dto.OaRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaRankMapper {
    long countByExample(OaRankExample example);

    int deleteByExample(OaRankExample example);

    int deleteByPrimaryKey(Integer rankId);

    int insert(OaRank record);

    int insertSelective(OaRank record);

    List<OaRank> selectByExample(OaRankExample example);

    OaRank selectByPrimaryKey(Integer rankId);

    int updateByExampleSelective(@Param("record") OaRank record, @Param("example") OaRankExample example);

    int updateByExample(@Param("record") OaRank record, @Param("example") OaRankExample example);

    int updateByPrimaryKeySelective(OaRank record);

    int updateByPrimaryKey(OaRank record);
}