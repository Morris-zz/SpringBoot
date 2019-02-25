package com.example.oppo.demo.enums;

/**  响应编码
 * @author zhaozheng
 * @create 2019/2/25
 **/
public enum ResponseStatus {

    SUSSESSED(1,"成功"),
    FAILED(2,"失败");



    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
