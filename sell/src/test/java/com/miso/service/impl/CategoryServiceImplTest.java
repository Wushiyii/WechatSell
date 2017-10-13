package com.miso.service.impl;

import com.miso.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory one = categoryService.findOne(2);
        System.out.println(one);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotNull(list);
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("儿童玩具");
        productCategory.setCategoryType(7);
        ProductCategory category = categoryService.save(productCategory);

        System.out.println(category);
    }

}