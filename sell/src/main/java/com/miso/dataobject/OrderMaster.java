package com.miso.dataobject;

import com.miso.enums.OrderStatusEnum;
import com.miso.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单对象
 * Created by Wushiyi on 2017-10-11.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;//买家姓名

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;//订单总金额

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();//订单状态:0 新订单

    private Integer payStatus = PayStatusEnum.WAIT.getCode();//支付状态：WAIT :等待支付

    private Date createTime;

    private Date updateTime;

}
