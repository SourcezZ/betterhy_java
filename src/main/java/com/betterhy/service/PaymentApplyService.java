package com.betterhy.service;

import com.betterhy.constant.ApplyType;
import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.generate.OaAuthJnlMapper;
import com.betterhy.db.dao.generate.OaPaymentMapper;
import com.betterhy.db.dto.OaAuthJnl;
import com.betterhy.db.dto.OaPayment;
import com.betterhy.db.dto.OaUser;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.OaUtils;
import com.betterhy.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 报销申请服务
 *
 * @author Source
 * @date 2020-08-13 20:06
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class PaymentApplyService {

    public Result paymentApply(@RequestBody OaPayment oaPayment) {
        OaUser user = UserUtils.getUser();

        oaPayment.setPaymentId(OaUtils.generateId());
        oaPayment.setUserId(user.getUserId());
        oaPayment.setUsername(user.getUsername());

        DataAccessManager.getMapper(OaPaymentMapper.class).insertSelective(oaPayment);

        //插入审核流水表
        OaAuthJnl oaAuthJnl = new OaAuthJnl();
        oaAuthJnl.setApplyId(oaPayment.getPaymentId());
        oaAuthJnl.setApplyType(ApplyType.PAYMENT);
        oaAuthJnl.setUserId(oaPayment.getUserId());
        oaAuthJnl.setUsername(oaPayment.getUsername());
        OaUser authUser = OaUtils.getAuthPerson();
        assert authUser != null;
        oaAuthJnl.setAuthUserId(authUser.getUserId());
        oaAuthJnl.setAuthUsername(authUser.getUsername());
        DataAccessManager.getMapper(OaAuthJnlMapper.class).insertSelective(oaAuthJnl);

        return ResultFactory.buildSuccessResult("申请成功");
    }
}
