package com.betterhy.common.result;

/**
 * 返回类
 *
 * @author Source
 * @date 2020-06-29 16:53
 **/
public class Result {
    private int returnCode;
    private String returnMsg;
    private Object result;

    public Result(int code, String message, Object result) {
        this.returnCode = code;
        this.returnMsg = message;
        this.result = result;
    }

    public Result() {

    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object data) {
        this.result = data;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "returnCode=" + returnCode +
                ", returnMsg='" + returnMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
