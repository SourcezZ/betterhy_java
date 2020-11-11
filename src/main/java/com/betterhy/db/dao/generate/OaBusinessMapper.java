package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaBusiness;
import com.betterhy.db.dto.OaBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaBusinessMapper {
    long countByExample(OaBusinessExample example);

    int deleteByExample(OaBusinessExample example);

    int deleteByPrimaryKey(Long businessId);

    int insert(OaBusiness record);

    int insertSelective(OaBusiness record);

    List<OaBusiness> selectByExample(OaBusinessExample example);

    OaBusiness selectByPrimaryKey(Long businessId);

    int updateByExampleSelective(@Param("record") OaBusiness record, @Param("example") OaBusinessExample example);

    int updateByExample(@Param("record") OaBusiness record, @Param("example") OaBusinessExample example);

    int updateByPrimaryKeySelective(OaBusiness record);

    int updateByPrimaryKey(OaBusiness record);
}