package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.AdminRole;
import com.betterhy.db.dto.AdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminRoleMapper {
    long countByExample(AdminRoleExample example);

    int deleteByExample(AdminRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    List<AdminRole> selectByExample(AdminRoleExample example);

    AdminRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}