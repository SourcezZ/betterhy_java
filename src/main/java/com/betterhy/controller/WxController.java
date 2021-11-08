package com.betterhy.controller;

import com.betterhy.common.utils.WeixinCheckoutUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单控制
 *
 * @author Source
 * @date 2020-07-07 12:16
 **/
@RestController
public class WxController {

    @PostMapping("/api/get_wechat")
    public String getWechat(String signature,String timestamp,String nonce,String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && WeixinCheckoutUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }

        return null;
    }


}
