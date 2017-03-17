package com.seed.entity.book;

/**
 * BookInfo 书籍详细信息表的 实体类
 * create by Jack at 2017-3-17
 */
public class BookInfo extends BookBase{

    private Integer bid;

    private String title;

    private String code;

    private String sort;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

}