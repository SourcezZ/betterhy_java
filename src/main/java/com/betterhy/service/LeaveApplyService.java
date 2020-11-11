package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dao.generate.OaLeaveMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaLeave;
import com.betterhy.db.dto.OaLeaveExample;
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

/**
 * 请假申请服务
 *
 * @author Source
 * @date 2020-08-12 17:24
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class LeaveApplyService {

    public Result leaveApply(@RequestBody Map<String, Object> reqMap) {
        OaUser user = UserUtils.getUser();
        Date leaveBeginDate = DateUtils.parseDate(reqMap.get(Dict.LEAVE_BEGIN_DATE));
        Date leaveEndDate = DateUtils.parseDate(reqMap.get(Dict.LEAVE_END_DATE));
        if (leaveBeginDate.after(leaveEndDate)){
            return ResultFactory.buildFailResult("开始日期不能大于结束日期");
        }

        OaSigninExample example = new OaSigninExample();
        example.createCriteria().andSigninDateBetween(leaveBeginDate, leaveEndDate).andUserIdEqualTo(user.getUserId());
        List<OaSignin> oaSignins = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(example);
        if (!oaSignins.isEmpty()){
            return ResultFactory.buildFailResult("申请日期包含已打卡日期");
        }

        OaLeaveExample oaLeaveExample = new OaLeaveExample();
        oaLeaveExample.createCriteria().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andLeaveBeginDateLessThanOrEqualTo(leaveEndDate)
                .andLeaveBeginDateGreaterThanOrEqualTo(leaveBeginDate);
        oaLeaveExample.or().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andLeaveBeginDateLessThan(leaveBeginDate)
                .andLeaveEndDateGreaterThan(leaveEndDate);
        oaLeaveExample.or().andUserIdEqualTo(user.getUserId()).andAuthStatusNotEqualTo(2)
                .andLeaveEndDateGreaterThanOrEqualTo(leaveBeginDate)
                .andLeaveEndDateLessThanOrEqualTo(leaveEndDate);
        List<OaLeave> oaLeaveList = DataAccessManager.getMapper(OaLeaveMapper.class).selectByExample(oaLeaveExample);
        if (!oaLeaveList.isEmpty()){
            return ResultFactory.buildFailResult("申请日期内已有申请记录");
        }

        int beginDateType = Integer.parseInt((String) reqMap.get(Dict.BEGIN_DATE_TYPE));
        int endDateType = Integer.parseInt((String) reqMap.get(Dict.END_DATE_TYPE));
        //插入请假申请表
        OaLeave record = new OaLeave();
        record.setLeaveId(OaUtils.generateId());
        record.setUserId(user.getUserId());
        record.setUsername(user.getUsername());
        record.setLeaveBeginDate(leaveBeginDate);
        record.setLeaveEndDate(leaveEndDate);
        record.setBeginDateType(beginDateType);
        record.setEndDateType(endDateType);
        record.setRemark((String) reqMap.get(Dict.REMARK));
        DataAccessManager.getMapper(OaLeaveMapper.class).insertSelective(record);

        //插入审核流水表
        OaAuthJnl oaAuthJnl = new OaAuthJnl();
        oaAuthJnl.setApplyId(record.getLeaveId());
        oaAuthJnl.setApplyType(ApplyType.LEAVE);
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
