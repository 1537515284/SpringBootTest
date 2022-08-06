package com.ls.service.impl;

import com.ls.dao.ProductInfo;
import com.ls.service.ProductInfoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Override
    public ProductInfo getOne(ProductInfo productInfo) {
        return new ProductInfo()
                .setId(10L)
                .setProductName("老中医痔疮膏")
                .setProductDescription("百年老品牌，专注痔疮治疗")
                .setProductPrice(BigDecimal.valueOf(36.6))
                .setProductStatus(1);
    }
}
