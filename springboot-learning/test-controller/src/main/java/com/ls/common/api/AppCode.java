package com.ls.common.api;

import lombok.Getter;

@Getter
public enum AppCode implements StatusCode{

    APP_ERROR(2000, "业务异常"),
    PRICE_ERROR(2001, "价格异常"),
    ORDER_NOT_EXIST(2003,"订单不存在");

    private int code;
    private String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
