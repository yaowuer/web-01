package com.nf152.web01.web.book.user;

import com.nf152.web01.bean.Book;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void add(Book book, int count) {
        CartItem item = items.get(book.getId());
        if (item == null) {
            items.put(book.getId(), new CartItem(book, count));
        } else {
            item.setCount(item.getCount() + count);
        }
    }

    public void remove(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public Collection<CartItem> getAll () {
        return items.values();
    }

}
