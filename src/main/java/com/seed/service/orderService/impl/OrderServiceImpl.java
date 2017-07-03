package com.seed.service.orderService.impl;

import com.seed.dao.orderMapper.IOrdersMapper;
import com.seed.entity.order.Orders;
import com.seed.service.orderService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by summer on 2017/6/18.
 * 2017/6/18 13:35
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrdersMapper ordersMapper;

    public int InsertNewOrder(Orders orders) {
        ordersMapper.insertSelective(orders);
        return orders.getOrderid();
    }
}
