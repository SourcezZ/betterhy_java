package com.betterhy.common.utils;

import com.betterhy.common.db.dto.OaUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户工具类
 *
 * @author Source
 * @date 2020-08-07 15:52
 **/
public class UserUtils {

    /**
     * 从session中获取user对象
     * @return oaUser
     */
    public static OaUser getUser(){
        return (OaUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 设置session中的user对象
     * @param user user对象
     */
    public static void setUser(OaUser user){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
    }
}
