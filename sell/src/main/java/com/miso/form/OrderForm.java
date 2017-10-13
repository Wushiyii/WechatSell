package com.miso.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Wushiyi on 2017-10-13.
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必须填")
    private String name;

    @NotEmpty(message = "手机号必须填")
    private String phone;

    @NotEmpty(message = "地址必须填")
    private String address;

    @NotEmpty(message = "openid必须填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
