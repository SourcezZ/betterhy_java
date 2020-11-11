package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.AdminMenu;
import com.betterhy.db.dto.AdminMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMenuMapper {
    long countByExample(AdminMenuExample example);

    int deleteByExample(AdminMenuExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(AdminMenu record);

    int insertSelective(AdminMenu record);

    List<AdminMenu> selectByExample(AdminMenuExample example);

    AdminMenu selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    int updateByExample(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    int updateByPrimaryKeySelective(AdminMenu record);

    int updateByPrimaryKey(AdminMenu record);
}