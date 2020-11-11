package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.AdminRolePermission;
import com.betterhy.db.dto.AdminRolePermissionExample;
import com.betterhy.db.dto.AdminRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRolePermissionMapper {
    long countByExample(AdminRolePermissionExample example);

    int deleteByExample(AdminRolePermissionExample example);

    int deleteByPrimaryKey(AdminRolePermissionKey key);

    int insert(AdminRolePermission record);

    int insertSelective(AdminRolePermission record);

    List<AdminRolePermission> selectByExample(AdminRolePermissionExample example);

    AdminRolePermission selectByPrimaryKey(AdminRolePermissionKey key);

    int updateByExampleSelective(@Param("record") AdminRolePermission record, @Param("example") AdminRolePermissionExample example);

    int updateByExample(@Param("record") AdminRolePermission record, @Param("example") AdminRolePermissionExample example);

    int updateByPrimaryKeySelective(AdminRolePermission record);

    int updateByPrimaryKey(AdminRolePermission record);
}