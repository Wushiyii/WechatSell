package com.miso.dto;

import lombok.Data;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@Data
public class CartDTO {

    private String productId;//商品ID

    private Integer productQuantity;//数量

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
