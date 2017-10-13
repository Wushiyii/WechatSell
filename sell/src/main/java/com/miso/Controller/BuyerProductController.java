package com.miso.Controller;

import com.miso.VO.ProductInfoVO;
import com.miso.VO.ProductVO;
import com.miso.VO.ResultVO;
import com.miso.dataobject.ProductCategory;
import com.miso.dataobject.ProductInfo;
import com.miso.service.CategoryService;
import com.miso.service.ProductInfoService;
import com.miso.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wushiyi on 2017-10-9.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
//
//        //传统做法
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简做法 lamda

        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.拼装JSON

        //遍历类目，装入对于的View Object

        List<ProductVO> productVOList = new ArrayList<>();

        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategorytype(productCategory.getCategoryType());


            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();

            //遍历内部JSON -----每个类目下的商品
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }

}

