package com.miso.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@Entity
@Data
public class ProductInfo  {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;//库存

    private String productDescription;//商品描述

    private String productIcon;//小图片链接

    private Integer productStatus;//商品状态 0 ：正常 1：下架

    private Integer categoryType;//类目编号
}
