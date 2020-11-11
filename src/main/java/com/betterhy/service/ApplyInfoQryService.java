package com.betterhy.service;

import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dao.generate.OaBusinessMapper;
import com.betterhy.db.dao.generate.OaLeaveMapper;
import com.betterhy.db.dao.generate.OaPaymentMapper;
import com.betterhy.db.dao.generate.OaSigninLaterMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaAuthJnlExample;
import com.betterhy.db.dto.OaBusiness;
import com.betterhy.db.dto.OaLeave;
import com.betterhy.db.dto.OaPayment;
import com.betterhy.db.dto.OaSigninLater;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.BeanUtils;
import com.betterhy.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 申请查询服务
 *
 * @author Source
 * @date 2020-08-12 17:24
 **/
@Service
public class ApplyInfoQryService {

    /**
     * 补卡申请详情查询
     * @param reqMap 请求map
     * @return Result
     */
    public Result signinLaterDetailQry(@RequestBody Map<String, Object> reqMap) {
        long applyId = Long.parseLong(String.valueOf(reqMap.get(Dict.APPLY_ID)));
        OaSigninLater oaSigninLater = DataAccessManager.getMapper(OaSigninLaterMapper.class).selectByPrimaryKey(applyId);
        Map<String, Object> resMap = BeanUtils.bean2Map(oaSigninLater);
        addAuthInfo(applyId, resMap);
        return ResultFactory.buildSuccessResult(resMap);
    }

    /**
     * 请假申请详情查询
     * @param reqMap 请求map
     * @return Result
     */
    public Result leaveDetailQry(@RequestBody Map<String, Object> reqMap) {
        long applyId = Long.parseLong(String.valueOf(reqMap.get(Dict.APPLY_ID)));
        OaLeave oaLeave = DataAccessManager.getMapper(OaLeaveMapper.class).selectByPrimaryKey(applyId);
        Map<String, Object> resMap = BeanUtils.bean2Map(oaLeave);
        addAuthInfo(applyId, resMap);
        return ResultFactory.buildSuccessResult(resMap);
    }

    /**
     * 出差申请详情查询
     * @param reqMap 请求map
     * @return Result
     */
    public Result businessDetailQry(@RequestBody Map<String, Object> reqMap) {
        long applyId = Long.parseLong(String.valueOf(reqMap.get(Dict.APPLY_ID)));
        OaBusiness oaBusiness = DataAccessManager.getMapper(OaBusinessMapper.class).selectByPrimaryKey(applyId);
        Map<String, Object> resMap = BeanUtils.bean2Map(oaBusiness);
        addAuthInfo(applyId, resMap);
        return ResultFactory.buildSuccessResult(resMap);
    }

    /**
     * 报销申请详情查询
     * @param reqMap 请求map
     * @return Result
     */
    public Result paymentDetailQry(@RequestBody Map<String, Object> reqMap) {
        long applyId = Long.parseLong(String.valueOf(reqMap.get(Dict.APPLY_ID)));
        OaPayment oaPayment = DataAccessManager.getMapper(OaPaymentMapper.class).selectByPrimaryKey(applyId);
        Map<String, Object> resMap = BeanUtils.bean2Map(oaPayment);
        addAuthInfo(applyId, resMap);
        return ResultFactory.buildSuccessResult(resMap);
    }

    /**
     * 申请详情加入审核信息
     * @param applyId 申请id
     * @param resMap 返回map
     */
    private void addAuthInfo(long applyId, Map<String, Object> resMap) {
        OaAuthJnlExample oaAuthJnlExample = new OaAuthJnlExample();
        oaAuthJnlExample.createCriteria().andApplyIdEqualTo(applyId);
        List<OaAuthJnl> oaAuthJnlList = DataAccessManager.getMapper(OaAuthJnlMapper.class).selectByExample(oaAuthJnlExample);
        if (!oaAuthJnlList.isEmpty()){
            OaAuthJnl oaAuthJnl = oaAuthJnlList.get(0);
            resMap.put("authUserName", oaAuthJnl.getAuthUsername());
            resMap.put("authRemark", oaAuthJnl.getAuthRemark());
            Date authDate = oaAuthJnl.getAuthDate();
            resMap.put("authDate", authDate == null ? null : DateUtils.getDate(oaAuthJnl.getAuthDate(), "yyyy-MM-dd HH:mm:ss"));
        }
    }
}
