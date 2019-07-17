package com.nf152.web01.web.book.user;

import com.nf152.web01.bean.Book;

public class CartItem {
    private Book book;
    private int count;

    public CartItem() {
    }

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
