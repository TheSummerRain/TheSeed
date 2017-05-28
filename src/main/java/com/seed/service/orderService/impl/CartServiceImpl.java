package com.seed.service.orderService.impl;

import com.seed.dao.orderMapper.ICartMapper;
import com.seed.service.orderService.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:42
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartMapper cartMapper;

    public List<HashMap<String, Object>> searchCartinfo(int userId) {
        return cartMapper.searchCartInfo(userId);
    }
}
