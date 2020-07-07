package com.whz.myblog.exception;

public enum CustomExceptionType {
    USER_INPUT_ERROR(4000,"用户输入异常"),
    SYSTEM_ERROR (5000,"系统服务异常"),
    OTHER_ERROR(9990,"其他未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    private String typeDesc;//异常类型中文描述

    private int code; //code

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}