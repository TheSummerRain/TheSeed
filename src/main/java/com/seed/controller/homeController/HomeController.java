package com.seed.controller.homeController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.goods.SimpGoods;
import com.seed.mydict.ImportDict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 这个是主页，默认进来的页面。也是主要的分类页。
 * 2017/4/26 22:19
 */
@Controller
@RequestMapping("/home")
public class HomeController extends SeedBaseController {


    //以下业务功能，按照首页模块划分主体。

    /**
     * @param request 请求
     * @param model   model 对象。
     * @return
     * @description 跳转到分类页，进入商城的第一入口。（按md，在按Tab就可马上打印这个模板。)
     * @author Jack
     * @date 23:07
     */
    @RequestMapping("/shouye")
    public String goHomePage(HttpServletRequest request, Model model) {

        //1、获取轮播banner数据。
        model.addAttribute("baner", getBanner());


        //2、获取最新的分类信息数据。（获取最高分类项目）【这里前台写死】

        //3、数据传递到页面。页面跳转，并加载数据。
        List<SimpGoods> ls = goodsService.getSimpGoodsList();
        if (null == ls) {
            return null;
        }

        List<SimpGoods> list1 = new ArrayList<SimpGoods>();
        List<SimpGoods> list2 = new ArrayList<SimpGoods>();
        List<SimpGoods> list3 = new ArrayList<SimpGoods>();

        for (SimpGoods sd : ls) {
            if (1 == sd.getTopid()) {
                list1.add(sd);
            }
            if (2 == sd.getTopid()) {
                list2.add(sd);
            }
            if (3 == sd.getTopid()) {
                list3.add(sd);
            }
        }

        model.addAttribute("gods1", list1);
        model.addAttribute("gods2", list2);
        model.addAttribute("gods3", list3);

        return "home/index";
    }

    /**
     * @param request 请求对象
     * @param model   model对象
     * @return String 到查询页面。
     * @description 分类主页的：顶部搜索功能。
     * @author Jack
     * @date 22:55
     */
    @RequestMapping("/homeSearch")
    public String homeSearch(HttpServletRequest request, Model model) {

        //携带搜索数据跳转，或者只是跳转界面。

        return "首页的搜索功能页面";
    }


    /**
     * @param request 请求
     * @param model   model对象
     * @return
     * @description 分类页的banner功能请求区域。
     * @author Jack
     * @date 23:00
     */
    public String homeBanner(HttpServletRequest request, Model model) {

        return "分类页的banner功能";
    }

    /**
     * @param request
     * @param model
     * @return
     * @description 根据用户点击的某个具体的二级大类，跳转到同类商品的列表页面。
     * @author Jack
     * @date 23:30
     */
    @RequestMapping("/sort/{typeId}")
    public String homeSortList(@PathVariable int typeId, HttpServletRequest request, Model model) {

        //1、查询大类下的所有商品。默认是按照销量排序的（前10条数据）
        //2、带数据跳转。
        //这里简化写。

        System.out.println("typeID = "+ typeId);
        List<SimpGoods> ls =  goodsService.getSortGoodsList(typeId);
        model.addAttribute("goodslst",ls);
        model.addAttribute("ListName", ImportDict.topType.get(typeId));

        return "home/sortlist";
    }


}
