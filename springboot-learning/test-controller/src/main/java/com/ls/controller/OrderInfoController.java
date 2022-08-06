package com.ls.controller;

import com.ls.dao.OrderInfo;
import com.ls.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/order-info")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/findById")
    public OrderInfo findById(Integer id){
        return orderInfoService.getOne(id);
    }
}
