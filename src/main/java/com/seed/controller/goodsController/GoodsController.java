package com.seed.controller.goodsController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.goods.GoodsDetail;
import com.seed.entity.goods.GoodsImgs;
import com.seed.entity.goods.GoodsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author JACK
 * @Des 这个负责控制商品的相关信息。比如查询，列表显示，排序啊等等。
 * @Date Created in 2017/4/26 23:45.
 * @Package com.base.controller.goodsController
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends SeedBaseController {


    //跳转商品详情界面。
    @RequestMapping("/detail/{goodsId}")
    public String toGoodsDetailPage(@PathVariable int goodsId , HttpServletRequest request, Model model){

        //获取商品数据。
        GoodsInfo gf =  goodsService.getOneGoodsInfoById(goodsId);
        if (null == gf) return null;
        //获取商品数据的详情数据。
        GoodsDetail gd = goodsService.getDetailById(goodsId);
        //获取商品的图片信息。
        List<GoodsImgs> gm =  goodsService.getGoodsImgsByGoodsId(goodsId);

        model.addAttribute("goods",gf);
        model.addAttribute("goodsDetail",gd);
        model.addAttribute("goodsImgas",gm);

        return "goods/goodsDetail";
    }


}
