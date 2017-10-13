package com.miso.service;

import com.miso.dto.OrderDTO;

/**
 *
 * Created by Wushiyi on 2017-10-13.
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
