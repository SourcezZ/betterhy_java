package com.betterhy.common.db.dao.generate;

import com.betterhy.common.db.dto.MyappStory;
import com.betterhy.common.db.dto.MyappStoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyappStoryDao {
    long countByExample(MyappStoryExample example);

    int deleteByExample(MyappStoryExample example);

    int deleteByPrimaryKey(Integer storyId);

    int insert(MyappStory record);

    int insertSelective(MyappStory record);

    List<MyappStory> selectByExample(MyappStoryExample example);

    MyappStory selectByPrimaryKey(Integer storyId);

    int updateByExampleSelective(@Param("record") MyappStory record, @Param("example") MyappStoryExample example);

    int updateByExample(@Param("record") MyappStory record, @Param("example") MyappStoryExample example);

    int updateByPrimaryKeySelective(MyappStory record);

    int updateByPrimaryKey(MyappStory record);
}