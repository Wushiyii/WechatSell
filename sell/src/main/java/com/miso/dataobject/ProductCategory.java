package com.miso.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@Entity
@DynamicUpdate // 动态更新，包括时间等等
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId; //类目ID

    private String categoryName;//类目名称

    private Integer categoryType;//类目编号


}
