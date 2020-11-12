package com.betterhy.common.constant;

/**
 * 审核类型
 * @author Source
 */
public interface ApplyType {
    /**
     * 补卡
     */
    int SIGNIN_LATER = 0;

    /**
     * 请假
     */
    int LEAVE = 1;

    /**
     * 外出
     */
    int BUSINESS = 2;

    /**
     * 报销
     */
    int PAYMENT = 3;
}
