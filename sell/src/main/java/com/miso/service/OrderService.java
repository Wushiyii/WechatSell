package com.miso.service;

import com.miso.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Wushiyi on 2017-10-11.
 */
public interface OrderService {
    //创建订单
    OrderDTO createOrder(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findAll(String buyerOpenid, Pageable pageable);

    //查询订单列表(全部)
    Page<OrderDTO> findAll(Pageable pageable);

    //取消订单
    OrderDTO cancelOrder(OrderDTO orderDTO);

    //完结订单
    OrderDTO finishOrder(OrderDTO orderDTO);

    //支付订单
    OrderDTO payOrder(OrderDTO orderDTO);
}
