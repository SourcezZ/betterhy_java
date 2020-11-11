package com.betterhy.filter;

import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.extend.AdminRolePermissionMapperExtend;
import com.betterhy.db.dto.OaUser;
import com.betterhy.utils.OaUtils;
import com.betterhy.utils.UserUtils;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * @author Source
 * @date 2020-07-09 14:40
 **/
public class UrlPathMatchingFilter extends PathMatchingFilter{
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // 放行 options 请求
        if (HttpMethod.OPTIONS.toString().equals((httpServletRequest).getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        if(true){
            return true;
        }

        // 登陆验证
        OaUser user = UserUtils.getUser();
        Subject subject = SecurityUtils.getSubject();
        if (user == null || !subject.isAuthenticated()) {
            OaUtils.setResponse(401, "需要登录");
            return false;
        }

        //权限验证
        String requestApi = getPathWithinApplication(request);
        logger.info(user.getUsername() + "访问接口：" + requestApi + "，验证访问权限" );
        String trans = requestApi.replace("/api/", "");
        if (trans.startsWith(Dict.FILE)){
            return true;
        }
        // 判断当前用户是否有相应权限
        boolean hasPermission = false;
        Map<String, Object> queryMap = Maps.newHashMapWithExpectedSize(1);
        queryMap.put("userId", user.getUserId());
        Set<String> permissions = DataAccessManager.getMapper(AdminRolePermissionMapperExtend.class).queryUserPermission(queryMap);
        for (String api : permissions) {
            if (trans.equals(api)) {
                hasPermission = true;
                break;
            }
        }
        if (hasPermission) {
            logger.info("访问权限：" + requestApi + "验证成功");
            return true;
        } else {
            String returnMsg = "当前用户没有访问接口" + requestApi + "的权限";
            OaUtils.setResponse(401, returnMsg);
            return false;
        }
    }
}
