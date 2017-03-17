package com.seed.entity;

/**
 * @Author Jack
 * @Des 测试类
 * @Date 2017/3/17 13:50
 */
public class Book {

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private long bookId;
    private String name;
    private int number;



}
