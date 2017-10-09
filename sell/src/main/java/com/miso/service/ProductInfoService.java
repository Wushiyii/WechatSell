package com.miso.service;

import com.miso.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Wushiyi on 2017-10-9.
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询上架的所有商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 以分页对象查询所有商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //TODO 加订单
    //TODO 减订单
}
