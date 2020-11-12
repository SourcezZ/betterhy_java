package com.betterhy.common.utils;

import com.betterhy.common.constant.Dict;
import com.betterhy.common.supportor.Pagination;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;

/**
 * sql工具类
 *
 * @author Source
 * @date 2020-09-08 09:10
 **/
public class SqlUtils {

    /**
     * 分页插件设置pageNum和pageSize
     * @param pageNum 页数
     * @param pageSize 分页条数
     */
    public static void startPage(int pageNum, int pageSize) {
        Pagination pagination = new Pagination(pageSize, pageNum);
        PageHelper.startPage(pagination.getFixedPageNum(), pagination.getFixedPageSize());
    }

    /**
     * 分页插件设置上下文中的总件数totalNum
     * @param map 返回的map
     * @param resultList 分页查询返回的结果
     */
    public static <E> void setPageHeader(Map<String, Object> map, List<E> resultList) {
        map.put(Dict.TOTAL_NUM, (int)(((Page<E>) resultList).getTotal()));
    }

    /**
     *
     * @param resultList 分页查询返回的结果
     * @param <E> E
     * @return 总条数
     */
    public static <E> long getTotalNum(List<E> resultList) {
        return ((Page<E>) resultList).getTotal();
    }
}
