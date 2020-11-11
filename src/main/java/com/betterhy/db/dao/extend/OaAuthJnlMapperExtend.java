package com.betterhy.db.dao.extend;

import java.util.List;
import java.util.Map;

public interface OaAuthJnlMapperExtend {
    /**
     * 补卡审核列表查询
     * @param param 参数
     * @return List<Map>
     */
    List<Map<String, Object>> signinLaterAuthListQry(Map<String, Object> param);

    /**
     * 请假审核列表查询
     * @param param 参数
     * @return List<Map>
     */
    List<Map<String, Object>> leaveAuthListQry(Map<String, Object> param);

    /**
     * 出差审核列表查询
     * @param param 参数
     * @return List<Map>
     */
    List<Map<String, Object>> businessAuthListQry(Map<String, Object> param);

    /**
     * 报销审核列表查询
     * @param param 参数
     * @return List<Map>
     */
    List<Map<String, Object>> paymentAuthListQry(Map<String, Object> param);
}