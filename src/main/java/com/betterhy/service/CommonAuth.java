package com.betterhy.service;

import com.betterhy.constant.Dict;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaUser;
import com.betterhy.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 通用auth处理
 *
 * @author Source
 * @date 2020-08-12 19:40
 **/
@Service
public class CommonAuth {

    public OaAuthJnl handleCommon(Map<String, Object> reqMap) throws Exception{
        //审核记录查询
        long authId = Long.parseLong(String.valueOf(reqMap.get("authId")));
        OaAuthJnl oaAuthJnl = DataAccessManager.getMapper(OaAuthJnlMapper.class).selectByPrimaryKey(authId);
        if (oaAuthJnl == null){
            throw new Exception("该审核记录不存在");
        }
        if (oaAuthJnl.getAuthStatus() != 0){
            throw new Exception("该审核记录已处理");
        }

        //更新审核流水表
        OaUser user = UserUtils.getUser();
        int authStatus = Integer.parseInt(String.valueOf(reqMap.get(Dict.AUTH_STATUS)));
        oaAuthJnl.setAuthStatus(authStatus);
        oaAuthJnl.setAuthUserId(user.getUserId());
        oaAuthJnl.setAuthUsername(user.getUsername());
        oaAuthJnl.setAuthRemark((String) reqMap.get(Dict.REMARK));
        oaAuthJnl.setAuthDate(new Date());
        DataAccessManager.getMapper(OaAuthJnlMapper.class).updateByPrimaryKeySelective(oaAuthJnl);

        return oaAuthJnl;
    }
}
