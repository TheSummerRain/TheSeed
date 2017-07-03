package com.seed.service.orderService;

import com.seed.entity.order.Cart;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:42
 */
public interface ICartService {

    //根据用户的UserId获取购物车里的相关信息。
    public List<HashMap<String, Object>> searchCartinfo(int userId);

    List<Cart> getCartListByUserId(Integer userid);

    void minAmount(Integer cartid);

    void addAmount(Integer cartid);
}
