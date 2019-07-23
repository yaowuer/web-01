package com.nf152.web01.test;

import com.nf152.web01.bean.book.Book;
import com.nf152.web01.bean.Student;
import com.nf152.web01.bean.book.Cart;
import com.nf152.web01.bean.book.Order;
import com.nf152.web01.util.DBUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Integer[] integers = new Integer[30];
        integers[0] = 1;
        integers[2] = 3;

        // 语法糖
        Integer[] int2 = new Integer[] {222, 333, 444, 555};
        Integer[] int3 = new Integer[4];
        int3[0] = 222;
        int3[1] = 333;
        int3[2] = 444;
        int3[3] = 555;

        System.out.println(int2);

        ArrayList objects = new ArrayList<>();
        objects.add(33);
        objects.add(444);
        objects.add(55555);
        objects.add(5555);
        objects.add("kdsjfksdjkf");
        objects.add(333.0f);
        objects.add(new Cart());
        objects.add(2, 5748757);
        objects.remove(5555);

        Object xxx = objects.get(0);

        ArrayList fruits = new ArrayList();
        fruits.add("apple");
        fruits.add("pear");
        fruits.add(1111);

        List<Order> orders = new ArrayList<Order>();
        //orders.add(3333);
        orders.add(new Order());
        Order order = orders.get(0);

        // 使用安全

        Map aaaa = new HashMap(); // Key - Value 键值对

        Map<String, Order> bbb = new HashMap<>();
        bbb.put("111", new Order());
        //bbb.put(222, new Order());

        aaaa.put(0, new Order());
        aaaa.put(1, new Order());
        aaaa.get(1);
        aaaa.get(0);

        aaaa.put(new Order(), 3);
//        aaaa.put("order1", new Order());
//        aaaa.get("order1");
//        aaaa.put("xiaoming", new Order());
//        aaaa.get("xiaoming");
    }
}
