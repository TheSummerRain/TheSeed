package com.seed.dao.bannermapper;
import com.seed.entity.banner.BannerInfo;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IBannerInfoMapper {

    int deleteByPrimaryKey(Integer bid);

    int insert(BannerInfo record);

    int insertSelective(BannerInfo record);

    BannerInfo selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(BannerInfo record);

    int updateByPrimaryKey(BannerInfo record);

    //新增如下

    //查询需要在前台显示的banner,如果可以，这里可以设置limit,不管怎么添加，只选择前3条。
    @Select("select * from seed_banner where isAlive ORDER BY sort desc,createtime desc ")
    @ResultMap("BaseResultMap")
    List<BannerInfo> getBannerList();








}