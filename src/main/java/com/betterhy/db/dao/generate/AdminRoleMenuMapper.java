package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.AdminRoleMenu;
import com.betterhy.db.dto.AdminRoleMenuExample;
import com.betterhy.db.dto.AdminRoleMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRoleMenuMapper {
    long countByExample(AdminRoleMenuExample example);

    int deleteByExample(AdminRoleMenuExample example);

    int deleteByPrimaryKey(AdminRoleMenuKey key);

    int insert(AdminRoleMenu record);

    int insertSelective(AdminRoleMenu record);

    List<AdminRoleMenu> selectByExample(AdminRoleMenuExample example);

    AdminRoleMenu selectByPrimaryKey(AdminRoleMenuKey key);

    int updateByExampleSelective(@Param("record") AdminRoleMenu record, @Param("example") AdminRoleMenuExample example);

    int updateByExample(@Param("record") AdminRoleMenu record, @Param("example") AdminRoleMenuExample example);

    int updateByPrimaryKeySelective(AdminRoleMenu record);

    int updateByPrimaryKey(AdminRoleMenu record);
}