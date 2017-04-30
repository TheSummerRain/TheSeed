package com.seed.service.bookservice.impl;

import com.seed.dao.bookmapper.IBookInfoMapper;
import com.seed.entity.book.BookInfo;
import com.seed.service.bookservice.IBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 20:42
 */
@Service
public class BookInfoServiceImpl implements IBookInfoService {

    @Autowired
    private IBookInfoMapper bookInfoMapper;

    public BookInfo getOneBookInfoById(int bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }



}
