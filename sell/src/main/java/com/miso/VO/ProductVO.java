package com.miso.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * JSON中传输的类目商品
 * Created by Wushiyi on 2017-10-9.
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;//类目名称

    @JsonProperty("type")
    private Integer categorytype;//类目类别/

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
