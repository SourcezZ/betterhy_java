package com.betterhy.controller;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.dto.OaPayment;
import com.betterhy.result.Result;
import com.betterhy.service.ApplyInfoQryService;
import com.betterhy.service.BusinessApplyService;
import com.betterhy.service.LeaveApplyService;
import com.betterhy.service.PaymentApplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 申请控制类
 *
 * @author Source
 * @date 2020-08-12 17:22
 **/
@RestController
public class ApplyController {

    @Resource
    LeaveApplyService leaveApplyService;
    @Resource
    ApplyInfoQryService applyInfoQryService;
    @Resource
    BusinessApplyService businessApplyService;
    @Resource
    PaymentApplyService paymentApplyService;

    /**
     * 请假申请
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaLeaveApply")
    public Result leaveApply(@RequestBody Map<String, Object> reqMap) {
        return leaveApplyService.leaveApply(reqMap);
    }

    /**
     * 出差申请
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaBusinessApply")
    public Result businessApply(@RequestBody Map<String, Object> reqMap) {
        return businessApplyService.businessApply(reqMap);
    }

    /**
     * 报销申请
     * @param oaPayment payment实体类
     * @return Result
     */
    @PostMapping("/api/oaPaymentApply")
    public Result paymentApply(@RequestBody OaPayment oaPayment) {
        return paymentApplyService.paymentApply(oaPayment);
    }

    /**
     * 申请详情查询
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaApplyDetailQry")
    public Result authDetailQry(@RequestBody Map<String, Object> reqMap) {
        int applyType = Integer.parseInt(String.valueOf(reqMap.get(Dict.APPLY_TYPE)));
        switch (applyType){
            case ApplyType.SIGNIN_LATER:
                return applyInfoQryService.signinLaterDetailQry(reqMap);
            case ApplyType.LEAVE:
                return applyInfoQryService.leaveDetailQry(reqMap);
            case ApplyType.BUSINESS:
                return applyInfoQryService.businessDetailQry(reqMap);
            case ApplyType.PAYMENT:
                return applyInfoQryService.paymentDetailQry(reqMap);
            default:
                return null;
        }
    }


}
