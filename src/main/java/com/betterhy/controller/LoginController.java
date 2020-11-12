package com.betterhy.controller;

import com.betterhy.common.db.dto.OaUser;
import com.betterhy.common.result.Result;
import com.betterhy.common.result.ResultFactory;
import com.betterhy.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登陆控制类
 *
 * @author Source
 * @date 2020-06-29 16:54
 **/

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody Map<String, Object> reqMap) {
        return loginService.login(reqMap);
    }

    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody OaUser user) {
        return loginService.register(user);
    }

    @GetMapping("api/logout")
    @ResponseBody
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping(value = "api/authentication")
    @ResponseBody
    public String authentication(){
        return "身份认证成功";
    }

}
