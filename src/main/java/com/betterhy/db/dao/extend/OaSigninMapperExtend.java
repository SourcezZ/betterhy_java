package com.betterhy.db.dao.extend;

import java.util.List;
import java.util.Map;

/**
 * @author Source
 */
public interface OaSigninMapperExtend {
    /**
     * 打卡次数统计查询
     * @param queryMap 查询
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> queryUserSigninInfo(Map<String, Object> queryMap);
}