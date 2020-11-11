package com.betterhy.controller;

import com.betterhy.result.Result;
import com.betterhy.service.SigninInfoQryService;
import com.betterhy.service.SigninLaterService;
import com.betterhy.service.SigninService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 考勤控制类
 *
 * @author Source
 * @date 2020-08-07 15:39
 **/
@RestController
public class SigninController {

    @Resource
    SigninService signinService;
    @Resource
    SigninInfoQryService signinInfoQryService;
    @Resource
    SigninLaterService signinLaterService;

    /**
     * 签到
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaSignin")
    public Result signin(@RequestBody Map<String, Object> reqMap) {
        return signinService.signin(reqMap);
    }

    /**
     * 打卡信息列表查询
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaSigninInfoListQry")
    public Result signinInfoListQry(@RequestBody Map<String, Object> reqMap) {
        return signinInfoQryService.signinInfoListQry(reqMap);
    }

    /**
     * 打卡次数统计查询
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaSigninTimesStatisticsQry")
    public Result signinTimesStatisticsQry(@RequestBody Map<String, Object> reqMap) {
        return signinInfoQryService.signinTimesStatisticsQry(reqMap);
    }

    /**
     * 补卡申请
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaSigninLater")
    public Result signinLater(@RequestBody Map<String, Object> reqMap) {
        return signinLaterService.signinLater(reqMap);
    }

}
