package com.seed.service.orderService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:42
 */
public interface ICartService {

    //根据用户的UserId获取购物车里的相关信息。
    public List<HashMap<String, Object>> searchCartinfo(int userId);

}
