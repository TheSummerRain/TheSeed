package com.seed.service.orderService;

import com.seed.entity.order.Orders;

/**
 * Created by summer on 2017/6/18.
 * 2017/6/18 13:34
 */
public interface IOrderService {

    //插入一条新记录。
    public int InsertNewOrder(Orders orders);

}
