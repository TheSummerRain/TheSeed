package com.seed.controller;

import com.seed.service.bookservice.IBookInfoService;
import com.seed.service.userservice.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author Jack
 * @Des Seed种子基类的开头字母。如果文件名带有这个字母:必然是代表了一种基础的顶文件。
 * @Date 2017/3/17 18:08
 */
@Controller
public abstract class SeedBaseController {


    /*===================== 1、注册公用 service服务 =========================*/

    @Autowired
    protected IBookInfoService bookInfoService;

    @Autowired
    protected IUserInfoService userInfoService;

    /*===================== 2、注册其他服务 =========================*/




}
