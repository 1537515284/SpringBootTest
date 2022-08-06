package com.ls.dao;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductInfo {
    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private Integer productStatus;
}
