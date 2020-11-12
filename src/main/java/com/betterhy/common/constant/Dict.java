package com.betterhy.common.constant;

public interface Dict {
    /**
     * 上班
     */
    int SIGNIN_ON = 0;

    /**
     * 下班
     */
    int SIGNIN_OFF = 1;

    /**
     * 正常打卡
     */
    int NORMAL = 0;

    /**
     * 迟到
     */
    int LATER = 3;

    /**
     * 早退
     */
    int EARLY = 4;

    /**
     * 开始日期
     */
    String BEGIN_DATE = "beginDate";

    /**
     * 结束日期
     */
    String END_DATE = "endDate";

    /**
     * 签到日期
     */
    String SIGNIN_DATE = "signinDate";

    /**
     * 备注
     */
    String REMARK = "remark";

    /**
     * 备注
     */
    String AUTH_REMARK = "authRemark";

    /**
     * 审核类型
     */
    String APPLY_TYPE = "applyType";

    /**
     * 审核状态
     */
    String AUTH_STATUS = "authStatus";
    /**
     * 用户名
     */
    String USERNAME = "username";
    /**
     * 用户id
     */
    String USER_ID = "userId";
    /**
     * 请假开始日期
     */
    String LEAVE_BEGIN_DATE = "leaveBeginDate";
    /**
     * 请假结束日期
     */
    String LEAVE_END_DATE = "leaveEndDate";
    /**
     * 申请id
     */
    String APPLY_ID = "applyId";
    /**
     * 外出开始时间
     */
    String BUSINESS_BEGIN_DATE = "businessBeginDate";
    /**
     * 外出结束时间
     */
    String BUSINESS_END_DATE = "businessEndDate";
    /**
     * 外出地点
     */
    String BUSINESS_PLACE = "businessPlace";
    /**
     * 日期类型
     */
    String DATE_TYPE = "dateType";
    /**
     * 开始日期类型
     */
    String BEGIN_DATE_TYPE = "beginDateType";
    /**
     * 结束日期类型
     */
    String END_DATE_TYPE = "endDateType";
    /**
     * 页数
     */
    String PAGE_NUM = "pageNum";
    /**
     * 分页条数
     */
    String PAGE_SIZE = "pageSize";
    /**
     * 总条数
     */
    String TOTAL_NUM = "totalNum";

    /**
     * 审核员id
     */
    String AUTH_USER_ID = "authUserId";
    /**
     * 文件
     */
    String FILE = "file";
    /**
     * 文件名称
     */
    String FILE_NAME = "fileName";
}
