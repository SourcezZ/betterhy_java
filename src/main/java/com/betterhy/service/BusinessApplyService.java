package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dao.generate.OaBusinessMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaBusiness;
import com.betterhy.db.dto.OaBusinessExample;
import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninExample;
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
import java.util.Objects;

/**
 * 外出申请服务
 *
 * @author Source
 * @date 2020-08-12 17:24
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class BusinessApplyService {

    public Result businessApply(@RequestBody Map<String, Object> reqMap) {
        OaUser user = UserUtils.getUser();
        Date businessBeginDate = DateUtils.parseDate(reqMap.get(Dict.BUSINESS_BEGIN_DATE));
        Date businessEndDate = DateUtils.parseDate(reqMap.get(Dict.BUSINESS_END_DATE));
        if (businessBeginDate.after(businessEndDate)){
            return ResultFactory.buildFailResult("开始日期不能大于结束日期");
        }

        OaSigninExample example = new OaSigninExample();
        example.createCriteria().andSigninDateBetween(businessBeginDate, businessEndDate).andUserIdEqualTo(user.getUserId());
        List<OaSignin> oaSignins = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(example);
        if (!oaSignins.isEmpty()){
            return ResultFactory.buildFailResult("申请日期包含已打卡日期");
        }

        OaBusinessExample oaBusinessExample = new OaBusinessExample();
        oaBusinessExample.createCriteria().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andBusinessBeginDateLessThanOrEqualTo(businessEndDate)
                .andBusinessBeginDateGreaterThanOrEqualTo(businessBeginDate);
        oaBusinessExample.or().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andBusinessBeginDateLessThan(businessBeginDate)
                .andBusinessEndDateGreaterThan(businessEndDate);
        oaBusinessExample.or().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andBusinessEndDateGreaterThanOrEqualTo(businessBeginDate)
                .andBusinessEndDateLessThanOrEqualTo(businessEndDate);
        List<OaBusiness> oaBusinessList = DataAccessManager.getMapper(OaBusinessMapper.class).selectByExample(oaBusinessExample);
        if (!oaBusinessList.isEmpty()){
            return ResultFactory.buildFailResult("申请日期内已有申请记录");
        }

        int beginDateType = Integer.parseInt((String) reqMap.get(Dict.BEGIN_DATE_TYPE));
        int endDateType = Integer.parseInt((String) reqMap.get(Dict.END_DATE_TYPE));
        //插入外出申请表
        OaBusiness record = new OaBusiness();
        record.setBusinessId(OaUtils.generateId());
        record.setUserId(user.getUserId());
        record.setUsername(user.getUsername());
        record.setBusinessBeginDate(businessBeginDate);
        record.setBusinessEndDate(businessEndDate);
        record.setBeginDateType(beginDateType);
        record.setEndDateType(endDateType);
        record.setBusinessPlace((String) reqMap.get(Dict.BUSINESS_PLACE));
        record.setRemark((String) reqMap.get(Dict.REMARK));
        DataAccessManager.getMapper(OaBusinessMapper.class).insertSelective(record);

        //插入审核流水表
        OaAuthJnl oaAuthJnl = new OaAuthJnl();
        oaAuthJnl.setApplyId(record.getBusinessId());
        oaAuthJnl.setApplyType(ApplyType.BUSINESS);
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
