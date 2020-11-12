package com.betterhy.common.secure;

import com.betterhy.common.db.DataAccessManager;
import com.betterhy.common.db.dao.extend.AdminRolePermissionMapperExtend;
import com.betterhy.common.db.dao.generate.OaUserMapper;
import com.betterhy.common.db.dto.OaUser;
import com.google.common.collect.Maps;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Map;
import java.util.Set;

/**
 * @author Source
 * @date 2020-07-06 11:20
 **/
public class OaRealm extends AuthorizingRealm {

    /**
     * 简单重写获取授权信息方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的所有权限
        int userId = (int) principalCollection.getPrimaryPrincipal();
        Map<String, Object> queryMap = Maps.newHashMapWithExpectedSize(1);
        queryMap.put("userId", userId);
        Set<String> permissions = DataAccessManager.getMapper(AdminRolePermissionMapperExtend.class).queryUserPermission(queryMap);

        // 将权限放入授权信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }



    /**
     * 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
     * @return 登陆认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        int userId = Integer.parseInt(token.getPrincipal().toString());
        OaUser user = DataAccessManager.getMapper(OaUserMapper.class).selectByPrimaryKey(userId);
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
