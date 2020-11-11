package com.betterhy.db.dao.extend;

import java.util.Map;
import java.util.Set;

/**
 * @author Source
 */
public interface AdminRolePermissionMapperExtend {
    /**
     * 查询用户权限
     * @param queryMap 查询
     * @return permissionSet
     */
    Set<String> queryUserPermission(Map<String, Object> queryMap);
}