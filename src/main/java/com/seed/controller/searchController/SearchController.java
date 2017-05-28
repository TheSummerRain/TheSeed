package com.seed.controller.searchController;

import com.seed.controller.SeedBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 15:07
 */
@Controller
@RequestMapping("search")
public class SearchController extends SeedBaseController{


    @RequestMapping("toSearchPage")
    public String toSearchPage(HttpServletRequest request, Model model){


        return "search/searchPage";
    }


}
