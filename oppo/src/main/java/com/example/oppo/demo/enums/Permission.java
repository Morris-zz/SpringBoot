package com.example.oppo.demo.enums;

/**
 * @author zhaozheng
 * @create 2019/2/20
 **/
public enum Permission {
    ADMIN(0,"admin"),
    USER(1,"user"),
    DEVERLOPER(2,"developer");

    private int code;
    private String role;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    Permission(int code, String role) {
        this.code = code;
        this.role = role;
    }}
