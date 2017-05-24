package com.seed.entity.goods;

/**
 * Created by summer on 2017/5/24.
 * 2017/5/24 14:45
 */

//mini版的数据接收model.
public class SimpGoods extends GoodsInfo {

    //商品ID
    private Integer gdid;

    //顶级分类ID
    private Integer topid;

    //商品名称
    private String name;

    //商品图片集合，用json存储;或者string字符集合，用|表示多张图片。
    private String imgs;

    //原价（统一用分表示）
    private Integer price;

    //折扣价
    private Integer salesprice;

    //虚拟销量
    private Integer virtualsales;


}
