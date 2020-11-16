package com.betterhy.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.betterhy.common.db.DataAccessManager;
import com.betterhy.common.db.dao.generate.AdminRoleMenuMapper;
import com.betterhy.common.db.dao.generate.OaUserMapper;
import com.betterhy.common.db.dto.AdminRoleMenu;
import com.betterhy.common.db.dto.AdminRoleMenuExample;
import com.betterhy.common.db.dto.OaUser;
import com.betterhy.common.db.dto.OaUserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * betterhy工具类
 *
 * @author Source
 * @date 2020-07-03 15:38
 **/
public class OaUtils {

    private static final Logger logger = LoggerFactory.getLogger("OaUtils");

    /**
     * 获取e.printStackTrace() 的具体信息，赋值给String 变量，并返回
     *
     * @param e Exception
     * @return e.printStackTrace() 中 的信息
     */
    public static String getStackTraceInfo(Exception e) {

        StringWriter sw = null;
        PrintWriter pw = null;

        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (Exception ex) {
            return "发生错误";
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void setResponse(int returnCode, String returnMsg) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletResponse response = attributes.getResponse();
        assert response != null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out;
        JSONObject res = new JSONObject();
        res.put("returnCode", returnCode);
        res.put("returnMsg", returnMsg);
        try {
            out = response.getWriter();
            out.append(res.toString());
        } catch (IOException e) {
            logger.error(OaUtils.getStackTraceInfo(e));
        }
        logger.info(returnMsg);
    }

    public static List<String> getMenusByRoleId(String roleId) {
        AdminRoleMenuExample example = new AdminRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<AdminRoleMenu> adminRoleMenus = DataAccessManager.getMapper(AdminRoleMenuMapper.class).selectByExample(example);
        List<String> menus = new ArrayList<>();
        adminRoleMenus.forEach(adminRoleMenu -> menus.add(adminRoleMenu.getMenuId()));
        return menus;
    }

    /**
     * 地球半径
     */
    private final static double EARTH_RADIUS = 6378.137;

    /**
     * 计算两点之间经纬度距离，默认单位是m
     *
     * @param lat1Str 纬度1
     * @param lng1Str 经度1
     * @param lat2Str 纬度2
     * @param lng2Str 经度2
     * @return 距离
     */
    public static double getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
        double lat1 = Double.parseDouble(lat1Str);
        double lng1 = Double.parseDouble(lng1Str);
        double lat2 = Double.parseDouble(lat2Str);
        double lng2 = Double.parseDouble(lng2Str);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        DecimalFormat df = new DecimalFormat("#.00");
        s = Double.parseDouble(df.format(s));
        return 1000 * s;
    }

    /**
     * @param d 经纬度
     * @return double
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 生成id
     *
     * @return long
     */
    public static long generateId() {
        Random random = new Random();
        String res = String.valueOf(System.currentTimeMillis() - 1300000000000L);
        String randomInt = String.valueOf(random.nextInt(10));
        return Long.parseLong(res + randomInt);
    }

    /**
     * 重命名上传的文件
     *
     * @param fileName 文件名
     * @return 文件名
     */
    public static String renameUploadFileName(String fileName) {
        int splitIndex = fileName.lastIndexOf(".");
        if (splitIndex != -1) {
            String suffix = fileName.substring(splitIndex);
            fileName = fileName.substring(0, splitIndex) + DateUtils.getDateTimeNoSplit() + suffix;
        } else {
            fileName = fileName + DateUtils.getDateTimeNoSplit();
        }
        return fileName;
    }

    /**
     * obj转List
     *
     * @param obj   obj
     * @param clazz eg:String.class
     * @param <T>   泛型
     * @return List<T>
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

    /**
     * obj转Map
     *
     * @param obj obj
     * @return List<T>
     */
    public static Map<String, Object> castMap(Object obj) {
        Map<String, Object> result = new HashMap<>();
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                result.put((String) entry.getKey(), entry.getValue());
            }
            return result;
        }
        return null;
    }


    /**
     * 获取openid
     *
     * @param appId     appid
     * @param appSecret 密钥
     * @param code      请求码
     * @param grantType 通过方式
     * @return openid
     */
    public static String getOpenId(String appId, String appSecret,
                                   String code, String grantType) {
        String params = "appid=".concat(appId)
                .concat("&secret=").concat(appSecret)
                .concat("&js_code=").concat(code)
                .concat("&grant_type=").concat(grantType);

        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        // 解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);

        // 用户的唯一标识（openid）
        return (String) json.get("openid");
    }

    public static OaUser getAuthPerson() {
        OaUserExample example = new OaUserExample();
        example.createCriteria().andRankIdEqualTo(1);
        List<OaUser> list = DataAccessManager.getMapper(OaUserMapper.class).selectByExample(example);
        if (!list.isEmpty()) {
            Random random = new Random();
            int n = random.nextInt(list.size());
            return list.get(n);
        }
        return null;
    }

    /***
     * 获取客户端ip地址(可以穿透代理)
     * @param request
     * @return
     */
    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
//        logger.info("X-Forwarded-For:" + ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            logger.info("Proxy-Client-IP:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            logger.info("WL-Proxy-Client-IP:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            logger.info("HTTP_X_FORWARDED_FOR:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
            logger.info("HTTP_X_FORWARDED:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
            logger.info("HTTP_X_CLUSTER_CLIENT_IP:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            logger.info("HTTP_CLIENT_IP:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
            logger.info("HTTP_FORWARDED_FOR:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED");
            logger.info("HTTP_FORWARDED:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_VIA");
            logger.info("HTTP_VIA:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
            logger.info("REMOTE_ADDR:" + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            logger.info("getRemoteAddr:" + ip);
        }
        return ip;
    }

}
