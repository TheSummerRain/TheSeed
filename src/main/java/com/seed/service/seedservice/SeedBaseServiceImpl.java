package com.seed.service.seedservice;

import com.seed.dao.IBookInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 19:17
 */
public class SeedBaseServiceImpl implements ISeedBaseService{

  /*=============== 1、注册公用 mapper ================*/
  @Autowired
  private IBookInfoMapper bookInfoMapper;




}
