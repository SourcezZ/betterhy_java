package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaAuthJnlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaAuthJnlMapper {
    long countByExample(OaAuthJnlExample example);

    int deleteByExample(OaAuthJnlExample example);

    int deleteByPrimaryKey(Long authId);

    int insert(OaAuthJnl record);

    int insertSelective(OaAuthJnl record);

    List<OaAuthJnl> selectByExample(OaAuthJnlExample example);

    OaAuthJnl selectByPrimaryKey(Long authId);

    int updateByExampleSelective(@Param("record") OaAuthJnl record, @Param("example") OaAuthJnlExample example);

    int updateByExample(@Param("record") OaAuthJnl record, @Param("example") OaAuthJnlExample example);

    int updateByPrimaryKeySelective(OaAuthJnl record);

    int updateByPrimaryKey(OaAuthJnl record);
}