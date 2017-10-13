package com.miso.service.impl;

import com.miso.dataobject.OrderDetail;
import com.miso.dto.OrderDTO;
import com.miso.enums.OrderStatusEnum;
import com.miso.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private static final String BUYER_OPENID = "123456";
    private static final String ORDER_ID = "1507738752480162108";

    @Test
    public void createOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("zzzzzzzzz");
        orderDTO.setBuyerAddress("厦门市湖里区");
        orderDTO.setBuyerPhone("13246561322");
        orderDTO.setOrderId(BUYER_OPENID);
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //设置购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.createOrder(orderDTO);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询结果]result = {}",result);

    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findAll(BUYER_OPENID, pageRequest);
        System.out.println(orderDTOPage.getTotalElements());
    }

    @Test
    public void cancelOrder() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancelOrder(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finishOrder() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finishOrder(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),result.getOrderStatus());
    }

    @Test
    public void payOrder() throws Exception {}


}