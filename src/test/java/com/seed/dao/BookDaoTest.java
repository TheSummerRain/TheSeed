package com.seed.dao;

import com.seed.BaseTest;
import com.seed.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 14:24
 */
public class BookDaoTest extends BaseTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testQueryById() throws Exception{
        long bookid = 1000;
        Book book = bookMapper.selectByPrimaryKey(bookid);
        System.out.println(book.getName());
    }


}
