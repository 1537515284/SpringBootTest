package com.ls.service.impl;

import com.ls.common.api.AppCode;
import com.ls.dao.OrderInfo;
import com.ls.exception.APIException;
import com.ls.service.OrderInfoService;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Override
    public OrderInfo getOne(Integer orderId) {
        // 模拟dao查数据
        OrderInfo orderInfo = findById(orderId);
        if (null == orderInfo) {
            throw new APIException(AppCode.ORDER_NOT_EXIST, "订单号不存在：" + orderId);
        }
        return orderInfo;
    }

    private OrderInfo findById(Integer orderId) {
        return null;
    }
}
