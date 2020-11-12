package com.betterhy.common.constant;

/**
 * @author Source
 */

public enum AuthType {
    /**
     * 补卡
     */
    SIGNIN_LATER("补卡", 0),
    /**
     * 请假
     */
    LEAVE("请假", 1);

    private String name;
    private int index;

    AuthType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public int getIndex(){
        return this.index;
    }
}
