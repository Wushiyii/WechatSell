package com.miso.repository;

import com.miso.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Test
    public void saveTest(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(125.50));
        productInfo.setProductStock(50);
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("E:/sell/pic/皮蛋");
        productInfo.setProductDescription("此乃皮蛋瘦肉粥是也~");
        productInfo.setCategoryType(1);
        productInfoRepository.save(productInfo);
    }

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        System.out.println(productInfoList);

    }

}