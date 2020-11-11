package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.extend.OaAuthJnlMapperExtend;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.UserUtils;
import com.github.pagehelper.util.StringUtil;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 审核信息查询服务
 *
 * @author Source
 * @date 2020-08-11 19:34
 **/
@Service
public class AuthInfoQryService {

    /**
     * 审核列表查询
     *
     * @param reqMap 请求map
     * @return Result
     */
    public Result authListQry(@RequestBody Map<String, Object> reqMap) {

        Map<String, Object> param = Maps.newHashMapWithExpectedSize(5);
        if (StringUtil.isNotEmpty(String.valueOf(reqMap.get(Dict.AUTH_STATUS)))) {
            int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
            param.put(Dict.AUTH_STATUS, authStatus);
        }
        if (StringUtil.isNotEmpty(String.valueOf(reqMap.get(Dict.APPLY_TYPE)))) {
            int applyType = Integer.parseInt(String.valueOf(reqMap.get(Dict.APPLY_TYPE)));
            param.put(Dict.APPLY_TYPE, applyType);
        }
        if (StringUtil.isNotEmpty((String) reqMap.get(Dict.USERNAME))) {
            param.put(Dict.USERNAME, reqMap.get(Dict.USERNAME));
        }
        if (StringUtil.isNotEmpty((String) reqMap.get(Dict.USER_ID))) {
            param.put(Dict.USER_ID, reqMap.get(Dict.USER_ID));
        } else {
            param.put(Dict.AUTH_USER_ID, UserUtils.getUser().getUserId());
        }
        if (StringUtil.isNotEmpty((String) reqMap.get(Dict.BEGIN_DATE))) {
            param.put(Dict.BEGIN_DATE, reqMap.get(Dict.BEGIN_DATE) + " 00:00:00");
        }
        if (StringUtil.isNotEmpty((String) reqMap.get(Dict.END_DATE))) {
            param.put(Dict.END_DATE, reqMap.get(Dict.END_DATE) + " 23:59:59");
        }

        int applyType = Integer.parseInt(String.valueOf(reqMap.get(Dict.APPLY_TYPE)));
        List<Map<String, Object>> oaAuthJnlList;
        switch (applyType) {
            case ApplyType.SIGNIN_LATER:
                oaAuthJnlList = DataAccessManager.getMapper(OaAuthJnlMapperExtend.class).signinLaterAuthListQry(param);
                break;
            case ApplyType.LEAVE:
                oaAuthJnlList = DataAccessManager.getMapper(OaAuthJnlMapperExtend.class).leaveAuthListQry(param);
                break;
            case ApplyType.BUSINESS:
                oaAuthJnlList = DataAccessManager.getMapper(OaAuthJnlMapperExtend.class).businessAuthListQry(param);
                break;
            case ApplyType.PAYMENT:
                oaAuthJnlList = DataAccessManager.getMapper(OaAuthJnlMapperExtend.class).paymentAuthListQry(param);
                break;
            default:
                oaAuthJnlList = null;
                break;
        }

        return ResultFactory.buildSuccessResult(new HashMap<String, Object>(1) {{
            put("list", oaAuthJnlList);
        }});
    }
}
