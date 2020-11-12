package com.betterhy.common.result;

/**
 * 返回码
 *
 * @author Source
 * @date 2020-07-06 10:48
 **/
public enum ResultCode {
    //成功
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}