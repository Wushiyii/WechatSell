package com.miso.repository;

import com.miso.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Wushiyi on 2017-10-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    public void test1(){
        ProductCategory productCategory = categoryRepository.findOne(2);
        System.out.println(productCategory.getCategoryName());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生热门");
        productCategory.setCategoryType(6);
        ProductCategory result = categoryRepository.save(productCategory);
        Assert.assertNotNull(result);

    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = categoryRepository.findOne(5);
        productCategory.setCategoryName("女生热门-");
        categoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<ProductCategory> byCategoryTypeIn = categoryRepository.findByCategoryTypeIn(list);
        for (ProductCategory productCategory : byCategoryTypeIn){
            System.out.println(productCategory);
        }
    }

}