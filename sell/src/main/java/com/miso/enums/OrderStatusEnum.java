package com.miso.enums;

import lombok.Getter;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISH(1,"完结订单"),
    CANCEL(2,"已取消订单")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
