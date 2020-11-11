package com.betterhy.service;

import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaHolidayMapper;
import com.betterhy.db.dao.generate.OaSigninMapper;
import com.betterhy.db.dao.generate.OaWorkdayMapper;
import com.betterhy.db.dto.OaHoliday;
import com.betterhy.db.dto.OaHolidayExample;
import com.betterhy.db.dto.OaSignin;
import com.betterhy.db.dto.OaSigninExample;
import com.betterhy.db.dto.OaUser;
import com.betterhy.db.dto.OaWorkday;
import com.betterhy.db.dto.OaWorkdayExample;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.DateUtils;
import com.betterhy.utils.UserUtils;
import com.google.common.collect.Maps;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 打卡信息列表查询
 *
 * @author Source
 * @date 2020-08-10 14:52
 **/
@Service
public class SigninInfoQryService {
    private final static int SUNDAY = 1;
    private final static int SATURDAY = 7;

    public Result signinInfoListQry(@RequestBody Map<String, Object> reqMap) {
        OaUser user = UserUtils.getUser();
        Date beginDate = DateUtils.parseDate(reqMap.get(Dict.BEGIN_DATE));
        Date endDate = DateUtils.parseDate(reqMap.get(Dict.END_DATE));
        OaSigninExample example = new OaSigninExample();
        OaSigninExample.Criteria criteria = example.createCriteria();
        criteria.andSigninDateBetween(beginDate, endDate);
        String username = (String) reqMap.get(Dict.USERNAME);
        if (username != null) {
            criteria.andUsernameLike("%" + username + "%");
        } else {
            criteria.andUserIdEqualTo(user.getUserId());
        }
        List<OaSignin> oaSignins = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(example);
        return ResultFactory.buildSuccessResult(new HashMap<String, Object>(1) {{
            put("list", oaSignins);
        }});
    }

    public Result signinTimesStatisticsQry(@RequestBody Map<String, Object> reqMap) {
        List<Map<String, Object>> monthDayList = new ArrayList<>();

        Date beginDate = DateUtils.getDate((String) reqMap.get(Dict.BEGIN_DATE), "yyyy-MM-dd");
        Date endDate = DateUtils.getDate((String) reqMap.get(Dict.END_DATE), "yyyy-MM-dd");
        if (beginDate == null || endDate == null) {
            return ResultFactory.buildFailResult("开始时间或结束时间不能为空");
        }

        OaSigninExample example = new OaSigninExample();
        example.createCriteria().andSigninDateBetween(beginDate, endDate);
        example.setOrderByClause("SIGNIN_DATE, SIGNIN_TYPE");
        String username = (String) reqMap.get("username");
        if (username != null) {
            example.getOredCriteria().get(0).andUsernameLike("%" + username + "%");
        }
        List<OaSignin> signinInfoList = DataAccessManager.getMapper(OaSigninMapper.class).selectByExample(example);

        List<Map<String, Object>> topList = new ArrayList<>();
        Set<Integer> idSet = new HashSet<>();
        if (signinInfoList.isEmpty() && reqMap.get(Dict.USER_ID) != null && !"".equals(reqMap.get(Dict.USER_ID))){
            idSet.add(Integer.valueOf(String.valueOf(reqMap.get(Dict.USER_ID))));
        } else {
            for (OaSignin oaSignin : signinInfoList) {
                idSet.add(oaSignin.getUserId());
            }
        }
        idSet.forEach(id -> topList.add(new HashMap<String, Object>(16) {{ put("userId", id); }}));

        //处理monthDayList
        dealMonthDayList(monthDayList, beginDate, endDate);

        for (Map<String, Object> topMap : topList) {
            dealTopList(monthDayList, signinInfoList, topMap);
        }

        return ResultFactory.buildSuccessResult(topList);
    }

    /**
     * 处理外部list
     *
     * @param resList 返回的list
     * @param list    打卡list
     * @param topMap  外部list中的map
     */
    private void dealTopList(List<Map<String, Object>> resList, List<OaSignin> list, Map<String, Object> topMap) {
        int id = (int) topMap.get("userId");
        String username = null;
        List<Map<String, Object>> subList = new ArrayList<>(resList);
        //计算打卡次数，早到早退次数
        String currentDate = "";
        int signinDays = 0;
        int laterTimes = 0;
        int earlierTimes = 0;
        int workDays = 0;
        int absentDays = 0;
        for (Map<String, Object> map : subList) {
            String date = (String) map.get("date");
            int dateStatus = (int) map.get("dateStatus");
            workDays += dateStatus == 0 ? 1 : 0;
            for (OaSignin oaSignin : list) {
                if (oaSignin.getUserId() != id) {
                    continue;
                }

                @SuppressWarnings("unchecked")
                Map<String, Map<String, Object>> infoMap = (Map<String, Map<String, Object>>) map.get("infoMap");
                username = username == null ? oaSignin.getUsername() : username;
                if (oaSignin.getSigninDate().equals(DateUtils.getDate(date, "yyyy-MM-dd"))) {
                    int signinStatus = oaSignin.getSigninStatus();
                    if (signinStatus == 3) {
                        laterTimes += 1;
                    } else if (signinStatus == 4) {
                        earlierTimes += 1;
                    }

                    if (Dict.SIGNIN_ON == oaSignin.getSigninType()) {
                        // 打卡状态为上班时，记录日期
                        currentDate = date;
                        infoMap.put("on", getUsefulInfo(oaSignin));
                    } else if (currentDate.equals(date) && Dict.SIGNIN_OFF == oaSignin.getSigninType()) {
                        // 打卡状态为下班时，并且记录的日期与上班相同
                        signinDays += 1;
                        infoMap.put("off", getUsefulInfo(oaSignin));
                        map.put("signinStatus", 0);
                    } else if (Dict.SIGNIN_OFF == oaSignin.getSigninType()) {
                        // 打卡状态为下班时，放入下班卡
                        infoMap.put("off", getUsefulInfo(oaSignin));
                        map.put("signinStatus", 5);
                        absentDays += 1;
                    }
                }
            }
            if (map.get("signinStatus") == null){
                map.put("signinStatus", 5);
                if ((int) map.get("dateStatus") == 0){
                    absentDays += 1;
                }
            }
        }

        topMap.put(Dict.USERNAME, username);
        topMap.put("workDays", workDays);
        topMap.put("absentDays", absentDays);
        topMap.put("signinDays", signinDays);
        topMap.put("laterTimes", laterTimes);
        topMap.put("earlierTimes", earlierTimes);
        topMap.put("subList", subList);
    }

    /**
     * 处理monthList
     *
     * @param resList monthDayList
     * @param beginDate 开始日期
     * @param endDate 结束日期
     */
    private void dealMonthDayList(List<Map<String, Object>> resList, Date beginDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        //该月的每一天
        List<String> everyDayInMonth = DateUtils.getMonthFullDay(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, endDate);

        //该月假期holiday
        OaHolidayExample oaHolidayExample = new OaHolidayExample();
        oaHolidayExample.createCriteria().andHolidayDateBetween(beginDate, endDate);
        List<OaHoliday> oaHolidayList = DataAccessManager.getMapper(OaHolidayMapper.class).selectByExample(oaHolidayExample);

        //该月调休workday
        OaWorkdayExample oaWorkdayExample = new OaWorkdayExample();
        oaWorkdayExample.createCriteria().andWorkDateBetween(beginDate, endDate);
        List<OaWorkday> oaWorkdayList = DataAccessManager.getMapper(OaWorkdayMapper.class).selectByExample(oaWorkdayExample);

        for (String day : everyDayInMonth) {
            Map<String, Object> tmp = Maps.newHashMapWithExpectedSize(2);
            tmp.put("date", day);
            //0上班 1周六周日 2节假日
            tmp.put("dateStatus", 0);
            tmp.put("infoMap", Maps.newHashMapWithExpectedSize(2));
            resList.add(tmp);

            //调休与周六周日
            Date date = DateUtils.getDate(day, "yyyy-MM-dd");
            assert date != null;
            calendar.setTime(date);
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            boolean weekendFlag = weekDay == SATURDAY || weekDay == SUNDAY;
            boolean workdayFlag = false;
            for (OaWorkday oaWorkday : oaWorkdayList) {
                if (oaWorkday.getWorkDate().equals(date)) {
                    workdayFlag = true;
                    break;
                }
            }
            if (weekendFlag && !workdayFlag) {
                tmp.put("dateStatus", 1);
                continue;
            }

            //节假日
            for (OaHoliday oaHoliday : oaHolidayList) {
                if (day.equals(DateUtils.getDate(oaHoliday.getHolidayDate(), "yyyy-MM-dd"))) {
                    tmp.put("dateStatus", 2);
                    break;
                }
            }
        }
    }

    /**
     * 获取bean中的有效信息
     *
     * @param oaSignin 签到实体类
     * @return Map
     */
    private Map<String, Object> getUsefulInfo(OaSignin oaSignin) {
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(3);
        map.put("signinDate", oaSignin.getSigninDate());
        map.put("signinTime", oaSignin.getSigninTime());
        map.put("signinStatus", oaSignin.getSigninStatus());
        return map;
    }
}
