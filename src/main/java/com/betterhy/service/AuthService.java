package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaBusinessMapper;
import com.betterhy.db.dao.generate.OaLeaveMapper;
import com.betterhy.db.dao.generate.OaPaymentMapper;
import com.betterhy.db.dao.generate.OaSigninLaterMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaBusiness;
import com.betterhy.db.dto.OaLeave;
import com.betterhy.db.dto.OaPayment;
import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninLater;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Map;

/**
 * 审核服务
 *
 * @author Source
 * @date 2020-08-11 19:34
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class AuthService extends CommonAuth {

    private final static int MORNING = 0;
    private final static int AFTERNOON = 1;
    private final static int BOTH = 2;

    /**
     * 补卡审核
     * @param reqMap 请求map
     * @return Result
     * @throws Exception e
     */
    public Result authSigninLater(@RequestBody Map<String, Object> reqMap) throws Exception {

        OaAuthJnl oaAuthJnl = super.handleCommon(reqMap);
        int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
        //更新审核详情表
        OaSigninLater oaSigninLater = DataAccessManager.getMapper(OaSigninLaterMapper.class).selectByPrimaryKey(oaAuthJnl.getApplyId());
        int dateType = oaSigninLater.getDateType();
        oaSigninLater.setAuthStatus(authStatus);
        DataAccessManager.getMapper(OaSigninLaterMapper.class).updateByPrimaryKeySelective(oaSigninLater);

        if (authStatus == 1){
            //插入打卡记录表
            OaSignin oaSignin = new OaSignin();
            oaSignin.setUserId(oaSigninLater.getUserId());
            oaSignin.setUsername(oaSigninLater.getUsername());
            oaSignin.setSigninStatus(0);
            oaSignin.setSigninType(0);
            oaSignin.setApplyId(oaSigninLater.getSigninLaterId());
            oaSignin.setApplyType(ApplyType.SIGNIN_LATER);
            oaSignin.setSigninDate(oaSigninLater.getSigninLaterDate());
            insert(oaSignin, dateType);
        }

        return ResultFactory.buildSuccessResult("审核成功");
    }

    /**
     * 请假审核
     * @param reqMap 请求map
     * @return Result
     * @throws Exception e
     */
    public Result authLeaveApply(@RequestBody Map<String, Object> reqMap) throws Exception{
        OaAuthJnl oaAuthJnl = super.handleCommon(reqMap);
        int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
        //更新审核详情表
        OaLeave oaLeave = DataAccessManager.getMapper(OaLeaveMapper.class).selectByPrimaryKey(oaAuthJnl.getApplyId());
        int beginDateType = oaLeave.getBeginDateType();
        int endDateType = oaLeave.getEndDateType();
        oaLeave.setAuthStatus(authStatus);
        DataAccessManager.getMapper(OaLeaveMapper.class).updateByPrimaryKeySelective(oaLeave);

        if (authStatus == 1){
            //插入打卡记录表
            OaSignin oaSignin = new OaSignin();
            oaSignin.setUserId(oaLeave.getUserId());
            oaSignin.setUsername(oaLeave.getUsername());
            oaSignin.setSigninStatus(1);
            oaSignin.setApplyId(oaLeave.getLeaveId());
            oaSignin.setApplyType(ApplyType.LEAVE);

            Date leaveBeginDate = oaLeave.getLeaveBeginDate();
            Date leaveEndDate = oaLeave.getLeaveEndDate();
            insertIntoSignin(oaSignin, leaveBeginDate, leaveEndDate, beginDateType, endDateType, false);
        }

        return ResultFactory.buildSuccessResult("审核成功");
    }

    /**
     * 出差审核
     * @param reqMap 请求map
     * @return Result
     * @throws Exception e
     */
    public Result authBusinessApply(@RequestBody Map<String, Object> reqMap) throws Exception{
        OaAuthJnl oaAuthJnl = super.handleCommon(reqMap);
        int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
        //更新审核详情表
        OaBusiness oaBusiness = DataAccessManager.getMapper(OaBusinessMapper.class).selectByPrimaryKey(oaAuthJnl.getApplyId());
        int beginDateType = oaBusiness.getBeginDateType();
        int endDateType = oaBusiness.getEndDateType();
        oaBusiness.setAuthStatus(authStatus);
        DataAccessManager.getMapper(OaBusinessMapper.class).updateByPrimaryKeySelective(oaBusiness);

        if (authStatus == 1){
            //插入打卡记录表
            OaSignin oaSignin = new OaSignin();
            oaSignin.setUserId(oaBusiness.getUserId());
            oaSignin.setUsername(oaBusiness.getUsername());
            oaSignin.setSigninStatus(2);
            oaSignin.setApplyId(oaBusiness.getBusinessId());
            oaSignin.setApplyType(ApplyType.BUSINESS);
            Date businessBeginDate = oaBusiness.getBusinessBeginDate();
            Date businessEndDate = oaBusiness.getBusinessEndDate();
            insertIntoSignin(oaSignin, businessBeginDate, businessEndDate, beginDateType, endDateType, false);
        }

        return ResultFactory.buildSuccessResult("审核成功");
    }

    /**
     * 报销审核
     * @param reqMap 请求map
     * @return Result
     * @throws Exception e
     */
    public Result authPaymentApply(@RequestBody Map<String, Object> reqMap) throws Exception{
        OaAuthJnl oaAuthJnl = super.handleCommon(reqMap);
        int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
        //更新审核详情表
        OaPayment oaPayment = DataAccessManager.getMapper(OaPaymentMapper.class).selectByPrimaryKey(oaAuthJnl.getApplyId());
        oaPayment.setAuthStatus(authStatus);
        DataAccessManager.getMapper(OaPaymentMapper.class).updateByPrimaryKeySelective(oaPayment);

        return ResultFactory.buildSuccessResult("审核成功");
    }

    /**
     * 插入签到表
     * @param oaSignin 签到表实体
     * @param beginDateOrigin 开始时间
     * @param endDateOrigin 结束时间
     * @param beginDateType 开始日期类型
     * @param endDateType 结束日期类型
     */
    private void insertIntoSignin(OaSignin oaSignin, Date beginDateOrigin, Date endDateOrigin, int beginDateType, int endDateType, boolean middle) {
        String beginDate = DateUtils.getDate(beginDateOrigin, "yyyy-MM-dd");
        String endDate = DateUtils.getDate(endDateOrigin, "yyyy-MM-dd");
        oaSignin.setSigninDate(DateUtils.getDate(beginDate, "yyyy-MM-dd"));
        if (beginDate.equals(endDate)){
            if (endDateType == AFTERNOON){
                insert(oaSignin, BOTH);
            }else {
                insert(oaSignin, endDateType);
            }
        }else {
            //开始日期为下午，并且不是中间日期
            if (AFTERNOON == beginDateType && !middle){
                insert(oaSignin, beginDateType);
            }else {
                insert(oaSignin, BOTH);
            }

            Date tmpDate = beginDateOrigin;
            tmpDate = DateUtils.addDays(tmpDate, 1);
            insertIntoSignin(oaSignin, tmpDate, endDateOrigin, beginDateType, endDateType, true);
        }
    }

    private void insert(OaSignin oaSignin, int dateType){
        if (MORNING == dateType){
            oaSignin.setSigninType(0);
            DataAccessManager.getMapper(OaSigninMapper.class).insertSelective(oaSignin);
        }else if (AFTERNOON == dateType){
            oaSignin.setSigninType(1);
            DataAccessManager.getMapper(OaSigninMapper.class).insertSelective(oaSignin);
        }else if (BOTH == dateType){
            oaSignin.setSigninType(0);
            DataAccessManager.getMapper(OaSigninMapper.class).insertSelective(oaSignin);
            oaSignin.setSigninType(1);
            DataAccessManager.getMapper(OaSigninMapper.class).insertSelective(oaSignin);
        }
    }
}
