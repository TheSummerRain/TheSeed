package com.seed.service.bookservice.impl;

import com.seed.entity.book.BookInfo;
import com.seed.service.RegisterMapperService;
import com.seed.service.bookservice.IBookInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 20:42
 */
@Service
public class BookInfoServiceImpl extends RegisterMapperService implements IBookInfoService {
    public BookInfo getOneBookInfoById(int bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }



}
