package com.seed.dao.bookmapper;
import com.seed.dao.ISeedBaseMapper;
import com.seed.entity.book.BookInfo;
import org.apache.ibatis.annotations.Param;


public interface IBookInfoMapper extends ISeedBaseMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(@Param("bid") Integer bid);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}