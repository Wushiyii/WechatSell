package com.miso.enums;

import lombok.Getter;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    PRODUCT_NOT_EXIST(-1,"商品不存在"),

    PRODUCT_STOCK_ERROR(-2,"商品库存不足"),

    ORDER_NOT_EXIST(-3,"订单不存在"),

    ORDER_DETAIL_NOT_EXIST(-4,"订单详情不存在"),

    ORDER_STATUS_ERROR(-5,"订单状态不正确"),

    ORDER_UPDATE_FAIL(-6,"订单更新失败"),

    ORDER_DETAIL_EMPTY(-7,"订单中无商品详情"),

    ORDER_PAY_STATE_ERROE(-8,"商品支付状态不正确"),

    ORDER_PARAM_ERROR(1,"订单参数不正确"),

    CART_EMPTY(2,"购物车不能为空"),

    OPENID_EMPTY(3,"openid不能为空"),

    ORDER_OWNER_ERROR(4,"该订单不属于当前用户"),

    WECHAT_MP_ERROR(5,"微信方面错误"),

    ORDER_CANCEL_SUCCESS(6,"订单取消成功"),

    ORDER_FINISH_SUCCESS(7,"订单完结成功"),

    PRODUCT_STATUS_ERROR(8,"商品状态不正确"),

    PRODUCT_ONSALE_SUCCESS(9,"商品上架成功"),

    PRODUCT_ONSALE_ERROR(10,"商品上架失败"),

    PRODUCT_OFFSALE_SUCCESS(11,"商品下架成功"),

    PRODUCT_OFFSALE_ERROR(12,"商品下架失败")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
