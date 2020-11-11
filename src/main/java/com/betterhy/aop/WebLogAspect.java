package com.betterhy.aop;

import com.alibaba.fastjson.JSON;
import com.betterhy.utils.OaUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Web请求日志
 *
 * @author Source
 * @date 2020-07-21 09:57
 **/

@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private static final String FILE_CONTENT_TYPE = "multipart/form-data";

    @Pointcut("execution(public * com.betterhy.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 使用AOP前置通知拦截请求参数信息
     *
     * @param joinPoint jpa
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容 记录 最多半年数据迁移 云备份 nosql 数据库
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        StringBuilder args = new StringBuilder();
        try {
            if (!request.getContentType().startsWith(FILE_CONTENT_TYPE)){
                for (Object arg : joinPoint.getArgs()) {
                    args.append(JSON.toJSONString(arg));
                }
            }else {
                args.append("文件上传");
            }
        }catch (Exception e){
            args.append("无参数或部分参数转换失败");
        }

        logger.info("REQUEST : " + args);
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }

    }

    /**
     * 返回之前打印日志
     *
     * @param ret 返回对象
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        StringBuilder res;
        Map<String, String> map = new HashMap<>();
        map.put("storyQry", "1");
        map.put("commentQry", "1");
        try {
            if (map.containsKey(joinPoint.getSignature().getName())){
                logger.info("{}方法不打印返回对象",joinPoint.getSignature().getName());
                return ;
            }
            res = new StringBuilder(JSON.toJSONString(ret));
        }catch (Exception e){
            logger.info("返回参数转换失败");
            res = new StringBuilder(ret.toString());
        }

        // 处理完请求，返回内容
        final int max = 10000;
        if (res.length() > max) {
            res.delete(max, res.length());
        }
        logger.info("RESPONSE : " + res);
    }

    @AfterThrowing(throwing = "e", pointcut = "webLog()")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String msg = "调用" + joinPoint.getSignature().getName() + "方法发生异常，" + e;
        logger.error(msg);
        logger.error(OaUtils.getStackTraceInfo(e));
    }
}