package com.betterhy.common.supportor;

/**
 * 分页用基础信息
 *
 * @author heyuan
 * @date 2020/9/8 9:19
 */
public class Pagination {

	/**
	 * pageNum无效时的默认值（默认 = 1，第一页）
	 */
	public static final int DEFAULT_PAGE_NUM = 1;
	/**
	 * pageSize无效时的默认值(默认获取1000条)
	 */
	public static final int DEFAULT_PAGE_SIZE = 1000;

	private final Integer pageSize;
	private final Integer pageNum;

	public Pagination(Integer pageSize, Integer pageNum) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public int getSkipResults() {
		return isParamValid() ? pageSize * (pageNum - 1) : 0;
	}

	public int getMaxResults() {
		return isParamValid() ? pageSize * pageNum : 999;
	}

	public int getFixedPageNum() {
		//pageNum=null or 不大于>0 时，认为无效
		return isParamValid() ? pageNum : DEFAULT_PAGE_NUM;
	}

	public int getFixedPageSize() {
		//pageSize=null or 不大于>0 时，认为无效
		return isParamValid() ? pageSize : DEFAULT_PAGE_SIZE;
	}

	private boolean isParamValid() {
		return pageSize != null && pageSize > 0 && pageNum != null && pageNum > 0;
	}

}
