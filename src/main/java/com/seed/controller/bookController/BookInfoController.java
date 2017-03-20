package com.seed.controller.bookController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.book.BookInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 19:48
 */
@Controller
@RequestMapping("/book")
public class BookInfoController extends SeedBaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/toBookInfoPage")
    public String toBookInfoPage(Model model, HttpServletRequest request){
        logger.info("=====访问页面：toBookInfoPage======");

        BookInfo bf = bookInfoService.getOneBookInfoById(1000);

        logger.info(bf.getTitle()+"=================");

        String ctx = request.getContextPath().toString();

        System.out.println(request.getRequestURI());

        logger.info("=====ctx=="+ctx);

        model.addAttribute("ctx",ctx);
        model.addAttribute("bookInfo",bf);
        return "/bookinfo/bookInfo";
    }


}
