package com.betterhy.db.dao.generate;

import com.betterhy.db.dto.OaPayment;
import com.betterhy.db.dto.OaPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaPaymentMapper {
    long countByExample(OaPaymentExample example);

    int deleteByExample(OaPaymentExample example);

    int deleteByPrimaryKey(Long paymentId);

    int insert(OaPayment record);

    int insertSelective(OaPayment record);

    List<OaPayment> selectByExample(OaPaymentExample example);

    OaPayment selectByPrimaryKey(Long paymentId);

    int updateByExampleSelective(@Param("record") OaPayment record, @Param("example") OaPaymentExample example);

    int updateByExample(@Param("record") OaPayment record, @Param("example") OaPaymentExample example);

    int updateByPrimaryKeySelective(OaPayment record);

    int updateByPrimaryKey(OaPayment record);
}