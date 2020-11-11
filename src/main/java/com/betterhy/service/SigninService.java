package com.betterhy.service;

import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaSigninConfigMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninConfig;
import com.betterhy.db.dto.OaSigninExample;
import com.betterhy.db.dto.OaUser;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.BeanUtils;
import com.betterhy.utils.OaUtils;
import com.betterhy.utils.UserUtils;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 签到服务
 *
 * @author Source
 * @date 2020-08-10 11:05
 **/
@Service
public class SigninService {

    private final static int ONE = 1;
    private final static int TWO = 2;

    public Result signin(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> result = Maps.newHashMapWithExpectedSize(1);
        OaUser user = UserUtils.getUser();
        OaSignin oaSignin = BeanUtils.map2Bean(reqMap, OaSignin.class);
        oaSignin.setUserId(user.getUserId());
        oaSignin.setUsername(user.getUsername());
        oaSignin.setSigninDate(new Date());
        OaSigninConfig config = DataAccessManager.getMapper(OaSigninConfigMapper.class).selectByPrimaryKey(0);

        String longitude = config.getLongitude();
        String latitude = config.getLatitude();
        BigDecimal configDistance = BigDecimal.valueOf(config.getSigninRange());
        BigDecimal actualDistance = BigDecimal.valueOf(OaUtils.getDistance((String) reqMap.get("longitude"),
                (String) reqMap.get("latitude"), longitude, latitude));
        if (actualDistance.compareTo(configDistance) > 0) {
            return ResultFactory.buildFailResult("不在打卡范围");
        }

        OaSigninExample example = new OaSigninExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId()).andSigninDateEqualTo(new Date());
        List<OaSignin> oaSignins = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(example);

        int signinType = Integer.parseInt((String) reqMap.get("signinType"));

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        Date splitTime = calendar.getTime();
        boolean wrongType = now.before(splitTime) && Dict.SIGNIN_OFF == signinType;
        if (wrongType){
            return ResultFactory.buildFailResult("上午不可打卡下班");
        }

        //上下班时间
        String[] onTime = config.getOnTime().split(":");
        String[] offTime = config.getOffTime().split(":");
        if (oaSignins.isEmpty()) {
            handleSignStatus(oaSignin, onTime, reqMap, result);
        } else if (oaSignins.size() == ONE) {
            //上午已打卡，继续打上午卡
            boolean signOnFlag = Dict.SIGNIN_ON == signinType;
            //上午未打卡，下午已打卡
            boolean signOffFlag = Dict.SIGNIN_OFF == oaSignins.get(0).getSigninType();
            if (signOnFlag || signOffFlag) {
                return ResultFactory.buildFailResult("已打卡");
            }
            handleSignStatus(oaSignin, offTime, reqMap, result);
        } else if (oaSignins.size() == TWO) {
            return ResultFactory.buildFailResult("已打卡");
        }
        return ResultFactory.buildSuccessResult(result);
    }


    /**
     * 处理签到状态
     *
     * @param oaSignin 签到对象
     * @param time     上班时间或者下班时间
     * @param reqMap   请求体
     */
    private void handleSignStatus(OaSignin oaSignin, String[] time, Map<String, Object> reqMap, Map<String, Object> result) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(time[1]));
        Date configTime = calendar.getTime();
        String signInPlace = (String) reqMap.get("signinPlace");
        String longitude = (String) reqMap.get("longitude");
        String latitude = (String) reqMap.get("latitude");

        int signinType = Integer.parseInt((String) reqMap.get("signinType"));
        int signStatus = 0;
        if (Dict.SIGNIN_ON == signinType) {
            signStatus = now.after(configTime) ? Dict.LATER : Dict.NORMAL;
        } else if (Dict.SIGNIN_OFF == signinType) {
            signStatus = now.before(configTime) ? Dict.EARLY : Dict.NORMAL;
        }
        oaSignin.setSigninTime(new Date());
        oaSignin.setSigninStatus(signStatus);
        oaSignin.setSigninPlace(signInPlace);
        oaSignin.setLongitude(longitude);
        oaSignin.setLatitude(latitude);
        oaSignin.setSigninType(signinType);
        result.put("status", signStatus);
        DataAccessManager.getMapper(OaSigninMapper.class).insertSelective(oaSignin);
    }
}
