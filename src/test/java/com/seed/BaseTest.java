package com.seed;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 14:16
 */
// 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:springConfig/spring-dao.xml","classpath:springConfig/spring-service.xml"})
public class BaseTest {




}
