package com.miso.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miso.enums.ProductStatusEnum;
import com.miso.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@Entity
@Data
@DynamicUpdate
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

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
