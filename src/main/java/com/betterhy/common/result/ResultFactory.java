package com.betterhy.common.result;


/**
 * @author Source
 */
public class ResultFactory {

    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildSuccessResult() {
        return buildResult(ResultCode.SUCCESS, "成功");
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildResult(ResultCode resultCode, String message) {
        return new Result(resultCode.code, message, null);
    }

    public static Result buildResult(int code, String message, Object data) {
        return new Result(code, message, data);
    }
}