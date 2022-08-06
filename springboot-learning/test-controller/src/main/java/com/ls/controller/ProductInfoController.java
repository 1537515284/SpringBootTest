package com.ls.controller;

import com.ls.vo.ResultVo;
import com.ls.dao.ProductInfo;
import com.ls.service.ProductInfoService;
import com.ls.vo.ProductInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/product-info")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/findById")
    public ResultVo findById(@Validated ProductInfoVo vo){
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        return new ResultVo(productInfoService.getOne(productInfo));
    }

    @GetMapping("/findByVo")
    public ProductInfo findByVo(@Validated ProductInfoVo vo){
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        return productInfoService.getOne(productInfo);
    }

}
