package com.example.oppo.demo.util;

import com.example.oppo.demo.enums.ResponseStatus;

/**
 * @author zhaozheng
 * @create 2019/2/25
 **/
public class Response {
    private int errorCode;
    private String errorMsg;
    private Object data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public void setMsgAndCode(ResponseStatus status){
        this.errorCode = status.getCode();
        this.errorMsg = status.getMsg();
    }
}
