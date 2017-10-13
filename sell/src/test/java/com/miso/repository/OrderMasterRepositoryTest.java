package com.miso.repository;

import com.miso.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Wushiyi on 2017-10-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void saveTest(){

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3");
        orderMaster.setBuyerName("李四");
        orderMaster.setBuyerAddress("福州");
        orderMaster.setBuyerOpenid("asddsa");
        orderMaster.setBuyerPhone("128753211");
        orderMaster.setOrderAmount(new BigDecimal(3011));

        orderMasterRepository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> masters = orderMasterRepository.findByBuyerOpenid("asddsa", pageRequest);
        System.out.println(masters.getContent());
    }


}