package com.miso.service.impl;

import com.miso.dataobject.ProductInfo;
import com.miso.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productInfoService.findOne("1");
        System.out.println(productInfo);
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> all = productInfoService.findUpAll();
        System.out.println(all);
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> page = productInfoService.findAll(pageRequest);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2");
        productInfo.setProductName("花蛤豆腐汤");
        productInfo.setProductPrice(new BigDecimal(105.70));
        productInfo.setProductStock(21);
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("E:/sell/pic/花蛤豆腐汤");
        productInfo.setProductDescription("此乃花蛤豆腐汤是也~");
        productInfo.setCategoryType(2);

        productInfoService.save(productInfo);

    }
    @Test
    public void onsaleTest(){
        ProductInfo productInfo = productInfoService.onSale("2");
        System.out.println(productInfo.getProductStatusEnum().getMsg());
    }

    @Test
    public void offsaleTest(){
        ProductInfo productInfo = productInfoService.offSale("2");
        System.out.println(productInfo.getProductStatusEnum().getMsg());
    }

}