package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.AdminPermission;
import com.betterhy.db.dto.AdminPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPermissionMapper {
    long countByExample(AdminPermissionExample example);

    int deleteByExample(AdminPermissionExample example);

    int deleteByPrimaryKey(String permissionId);

    int insert(AdminPermission record);

    int insertSelective(AdminPermission record);

    List<AdminPermission> selectByExample(AdminPermissionExample example);

    AdminPermission selectByPrimaryKey(String permissionId);

    int updateByExampleSelective(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByExample(@Param("record") AdminPermission record, @Param("example") AdminPermissionExample example);

    int updateByPrimaryKeySelective(AdminPermission record);

    int updateByPrimaryKey(AdminPermission record);
}