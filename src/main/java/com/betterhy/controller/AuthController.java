package com.betterhy.controller;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.service.AuthInfoQryService;
import com.betterhy.service.AuthService;
import com.betterhy.utils.OaUtils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 审核控制类
 *
 * @author Source
 * @date 2020-08-11 19:33
 **/
@RestController
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Resource
    AuthService authService;
    @Resource
    AuthInfoQryService authInfoQryService;
    /**
     * 审批
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaAuth")
    public Result auth(@RequestBody Map<String, List<Map<String, Object>>> reqMap) {
        List<Map<String, Object>> list = reqMap.get("list");
        Map<String, Object> resMap = Maps.newHashMapWithExpectedSize(2);
        int successNum = 0;
        int failNum = 0;
        for (Map<String, Object> map : list) {
            try {
                int applyType = Integer.parseInt(String.valueOf(map.get(Dict.APPLY_TYPE)));
                switch (applyType){
                    case ApplyType.SIGNIN_LATER:
                        authService.authSigninLater(map);
                        break;
                    case ApplyType.LEAVE:
                        authService.authLeaveApply(map);
                        break;
                    case ApplyType.BUSINESS:
                        authService.authBusinessApply(map);
                        break;
                    case ApplyType.PAYMENT:
                        authService.authPaymentApply(map);
                        break;
                    default:
                        break;
                }
                successNum += 1;
            }catch (Exception e){
                failNum += 1;
                log.error(OaUtils.getStackTraceInfo(e));
            }
        }
        resMap.put("successNum", successNum);
        resMap.put("failNum", failNum);
        return ResultFactory.buildSuccessResult(resMap);

    }

    /**
     * 审批列表查询
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaAuthListQry")
    public Result authListQry(@RequestBody Map<String, Object> reqMap) {
        return authInfoQryService.authListQry(reqMap);
    }


}
