package com.seed.service.bannerService.impl;

import com.seed.dao.bannermapper.IBannerInfoMapper;
import com.seed.entity.banner.BannerInfo;
import com.seed.service.bannerService.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by summer on 2017/5/19.
 * 2017/5/19 13:32
 */
@Service
public class BannerServiceImpl implements IBannerService{

    @Autowired
    private IBannerInfoMapper bannerInfoMapper;

    public List<BannerInfo> getBannerList() {
      /*  List<BannerInfo> bf = new ArrayList<BannerInfo>();
        bf= bannerInfoMapper.getBannerList();*/
        return bannerInfoMapper.getBannerList();
    }
}
