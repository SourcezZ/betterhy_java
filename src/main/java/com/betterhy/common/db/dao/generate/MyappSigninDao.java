package com.betterhy.common.db.dao.generate;

import com.betterhy.common.db.dto.MyappSignin;
import com.betterhy.common.db.dto.MyappSigninExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyappSigninDao {
    long countByExample(MyappSigninExample example);

    int deleteByExample(MyappSigninExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyappSignin record);

    int insertSelective(MyappSignin record);

    List<MyappSignin> selectByExample(MyappSigninExample example);

    MyappSignin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyappSignin record, @Param("example") MyappSigninExample example);

    int updateByExample(@Param("record") MyappSignin record, @Param("example") MyappSigninExample example);

    int updateByPrimaryKeySelective(MyappSignin record);

    int updateByPrimaryKey(MyappSignin record);
}