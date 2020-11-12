package com.betterhy.common.db.dao.generate;

import com.betterhy.common.db.dto.MyappComment;
import com.betterhy.common.db.dto.MyappCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyappCommentDao {
    long countByExample(MyappCommentExample example);

    int deleteByExample(MyappCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(MyappComment record);

    int insertSelective(MyappComment record);

    List<MyappComment> selectByExample(MyappCommentExample example);

    MyappComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") MyappComment record, @Param("example") MyappCommentExample example);

    int updateByExample(@Param("record") MyappComment record, @Param("example") MyappCommentExample example);

    int updateByPrimaryKeySelective(MyappComment record);

    int updateByPrimaryKey(MyappComment record);
}