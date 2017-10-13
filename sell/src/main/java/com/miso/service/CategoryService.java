package com.miso.service;

import com.miso.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Wushiyi on 2017-10-9.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
