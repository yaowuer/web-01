package com.nf152.web01.web.book.user.bean;

import com.nf152.web01.bean.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public Collection<CartItem> getAll() {
        return items.values();
    }

    public int getCount() {
        return 3;
    }

    public float getTotalPrice() {
        float money = 0;
        for (CartItem c : items.values()) {
            money += c.getCount() * c.getBook().getPrice();
        }
        return money;
    }

    public boolean isNothing() {
        return items.isEmpty();
    }
}
