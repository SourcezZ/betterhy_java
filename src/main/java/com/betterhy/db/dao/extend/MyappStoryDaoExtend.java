package com.betterhy.db.dao.extend;

import java.util.List;
import java.util.Map;

public interface MyappStoryDaoExtend {
    /**
     * 补卡审核列表查询
     * @param param 参数
     * @return List<Map>
     */
    List<Map<String, Object>> storyQry(Map<String, Object> param);
}