package com.miso.repository;

import com.miso.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("1");
        orderDetail.setOrderId("1");
        orderDetail.setProductIcon("xxxxx/xxx.jpg");
        orderDetail.setProductId("2");
        orderDetail.setProductName("煎饺");
        orderDetail.setProductPrice(new BigDecimal(12));
        orderDetail.setProductQuantity(3);

        orderDetailRepository.save(orderDetail);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> detailList = orderDetailRepository.findByOrderId("1");
        System.out.println(detailList);
    }

}