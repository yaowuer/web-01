package com.nf152.web01.util;

import java.util.Date;
import java.util.UUID;

public class OrderUtil {
    public static String getOrderId () {
        return UUID.randomUUID().toString();
        //return String.valueOf("ORDER-" + System.currentTimeMillis() + "-" + Math.round(Math.random() * 100));
    }

    public static void main(String[] args) throws InterruptedException {
        // 时间戳，从 1970-1-1 0 0 0
        System.out.println(getOrderId());
    }
}
