package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dao.generate.OaSigninLaterMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninExample;
import com.betterhy.db.dto.OaSigninLater;
import com.betterhy.db.dto.OaSigninLaterExample;
import com.betterhy.db.dto.OaUser;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.DateUtils;
import com.betterhy.utils.OaUtils;
import com.betterhy.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 补卡服务
 *
 * @author Source
 * @date 2020-08-11 18:45
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class SigninLaterService {
    private final static int BOTH = 2;

    public Result signinLater(@RequestBody Map<String, Object> reqMap) {
        OaUser user = UserUtils.getUser();

        Date signinDate = DateUtils.parseDate(reqMap.get(Dict.SIGNIN_DATE));
        if (signinDate.after(DateUtils.parseDate(DateUtils.getDate()))){
            return ResultFactory.buildFailResult("补卡时间不应超过今天");
        }

        OaSigninExample oaSigninExample = new OaSigninExample();
        oaSigninExample.createCriteria().andSigninDateEqualTo(signinDate).andUserIdEqualTo(user.getUserId());
        List<OaSignin> oaSignins = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(oaSigninExample);
        int dateType = Integer.parseInt(String.valueOf(reqMap.get(Dict.DATE_TYPE)));
        if (!oaSignins.isEmpty()){
            if (dateType == BOTH){
                return ResultFactory.buildFailResult("该时段已有打卡记录，不允许补卡");
            }
            for (OaSignin oaSignin : oaSignins) {
                if (dateType == oaSignin.getSigninType()){
                    return ResultFactory.buildFailResult("该时段已有打卡记录，不允许补卡");
                }
            }
        }

        OaSigninLaterExample oaSigninLaterExample = new OaSigninLaterExample();
        oaSigninLaterExample.createCriteria()
                .andUserIdEqualTo(user.getUserId())
                .andAuthStatusEqualTo(0)
                .andSigninLaterDateEqualTo(signinDate);
        List<OaSigninLater> oaSigninLaterList = DataAccessManager.getMapper(OaSigninLaterMapper.class).selectByExample(oaSigninLaterExample);
        if (!oaSigninLaterList.isEmpty()){
            if (dateType == BOTH){
                return ResultFactory.buildFailResult("该时段已有申请记录，且未审核，不允许重复补卡");
            }
            for (OaSigninLater oaSigninLater : oaSigninLaterList) {
                if (dateType == oaSigninLater.getDateType()){
                    return ResultFactory.buildFailResult("该时段已有申请记录，且未审核，不允许重复补卡");
                }
            }
        }

        //插入补卡申请记录表
        OaSigninLater record = new OaSigninLater();
        long signinLaterId = OaUtils.generateId();
        record.setSigninLaterId(signinLaterId);
        record.setUserId(user.getUserId());
        record.setUsername(user.getUsername());
        record.setDateType(dateType);
        record.setSigninLaterDate(signinDate);
        record.setRemark((String) reqMap.get(Dict.REMARK));
        DataAccessManager.getMapper(OaSigninLaterMapper.class).insertSelective(record);

        //插入审核流水表
        OaAuthJnl oaAuthJnl = new OaAuthJnl();
        oaAuthJnl.setApplyId(signinLaterId);
        oaAuthJnl.setApplyType(ApplyType.SIGNIN_LATER);
        oaAuthJnl.setUserId(record.getUserId());
        oaAuthJnl.setUsername(record.getUsername());
        OaUser authUser = OaUtils.getAuthPerson();
        assert authUser != null;
        oaAuthJnl.setAuthUserId(authUser.getUserId());
        oaAuthJnl.setAuthUsername(authUser.getUsername());
        DataAccessManager.getMapper(OaAuthJnlMapper.class).insertSelective(oaAuthJnl);

        return ResultFactory.buildSuccessResult("申请成功");
    }
}
