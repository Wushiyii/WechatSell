package com.miso.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miso.dataobject.OrderDetail;
import com.miso.dto.OrderDTO;
import com.miso.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wushiyi on 2017-10-13.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("[对象转换错误]，String={}",orderForm.getItems());
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
