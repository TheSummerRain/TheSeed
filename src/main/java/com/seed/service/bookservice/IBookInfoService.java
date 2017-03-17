package com.seed.service.bookservice;

import com.seed.entity.book.BookInfo;
import com.seed.service.seedservice.ISeedBaseService;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 18:24
 */
public interface IBookInfoService extends ISeedBaseService {

    BookInfo getOneBookInfoById(int bookId);

}
