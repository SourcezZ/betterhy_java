package com.betterhy.controller;

import com.betterhy.common.db.DataAccessManager;
import com.betterhy.common.db.dao.generate.MyappSigninDao;
import com.betterhy.common.db.dto.MyappSignin;
import com.betterhy.common.db.dto.MyappSigninExample;
import com.betterhy.common.utils.DateUtils;
import com.betterhy.common.utils.MessageUtil;
import com.betterhy.common.utils.WeixinCheckoutUtil;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单控制
 *
 * @author Source
 * @date 2020-07-07 12:16
 **/
@RestController
public class WxController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RequestMapping(path="/api/get_wechat", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
    public String getWechat(String signature,String timestamp,String nonce,String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && WeixinCheckoutUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("GET微信接入成功");
            return echostr;
        }

        return null;
    }

    @RequestMapping(path="/api/get_wechat", method = { RequestMethod.POST }, produces = "application/xml;charset=UTF-8")
    public void postWechat(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap = MessageUtil.xmlToMap(request);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        response.setContentType("text/html;charset=UTF-8");

        logger.info(requestMap.toString());

        //发送方帐号(open_id)
        String fromUserName = requestMap.get("FromUserName");
        //公众帐号
        String toUserName = requestMap.get("ToUserName");
        //消息类型
        String msgType = requestMap.get("MsgType");
        //消息创建时间
        String createTime = requestMap.get("CreateTime");
        //微信服务器post过来的内容
        String weixinContent = requestMap.get("Content");
        logger.info("公众号用户发送过来的文本消息内容："+weixinContent);

        StringBuilder content = new StringBuilder("你好,已接收到内容。");

        if (weixinContent.startsWith("a")){
            content = new StringBuilder();
            String size = weixinContent.replace("a", "");
            int limit = 5;
            if (size.length() != 0){
                try {
                    limit = Integer.parseInt(size);
                } catch (NumberFormatException ignored) {
                }
            }
            MyappSigninExample example = new MyappSigninExample();
            example.createCriteria().andUserNameEqualTo("heyuan");
            example.setOrderByClause("ID DESC LIMIT " + limit);
            List<MyappSignin> list = DataAccessManager.getMapper(MyappSigninDao.class).selectByExample(example);
            for (MyappSignin myappSignin : list) {
                String status = "0".equals(myappSignin.getSignInFlag()) ? "未打" :
                        "1".equals(myappSignin.getSignInFlag()) ? "已打":
                        "9".equals(myappSignin.getSignInFlag()) ? "手动" : "异常" ;
                int signHour = Integer.parseInt(myappSignin.getSignInTime().split(":")[0]);

                String tmp = "ID:" + myappSignin.getId();
                tmp += "\n打卡类型:" + (signHour ==8 ? "上班" : "下班");
                tmp += "\n打卡时间:" + myappSignin.getSignInTime();
                tmp += "\n状态:" + status;
                tmp += "\n更新时间:" + DateUtils.getDate(myappSignin.getUpdateTime(), DateUtils.DATETIME_FORMAT);
                content.append(tmp).append("\n\n");
            }
        }

        String respMessage = "<xml>"
                +"<ToUserName><![CDATA["+fromUserName+"]]></ToUserName>"
                +"<FromUserName><![CDATA["+toUserName+"]]></FromUserName>"
                +"<CreateTime>" + createTime + "</CreateTime>"
                +"<MsgType><![CDATA[text]]></MsgType>"
                +"<Content><![CDATA[" + content + "]]></Content>"
                +"</xml>";

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        } finally {
            out.close();
            out = null;
        }
    }


}
