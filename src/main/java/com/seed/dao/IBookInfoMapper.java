package com.seed.dao;
import com.seed.entity.book.BookInfo;


public interface IBookInfoMapper extends ISeedBaseMapper{
    int deleteByPrimaryKey(Integer bid);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}