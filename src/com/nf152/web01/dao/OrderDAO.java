package com.nf152.web01.dao;

import com.nf152.web01.bean.book.Order;
import com.nf152.web01.util.DBUtil;
import com.nf152.web01.util.OrderUtil;
import com.nf152.web01.bean.book.Cart;
import com.nf152.web01.bean.book.CartItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    public String createOrder(Cart cart, String account, String receiver, String tel, String addr) {
        // 将这个交易请求，保存到数据库
        // 订单信息
        String orderId = OrderUtil.getOrderId();
        String sql = "insert into dingdan (id, account, receiver, phone, addr, create_at, status) values (?, ?, ?, ?, ?, ?, ?)";
        DBUtil.execute(sql,
                orderId,
                account,
                receiver,
                tel,
                addr,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                "1");

        sql = "insert into dingdan_xijie ('ddid', 'bookid', 'amount') values (?, ?, ?)";
        for (CartItem item : cart.getAll()) {
            DBUtil.execute(sql,
                    orderId,
                    item.getBook().getId(),
                    item.getCount());
        }

        return orderId;
    }

    public List<Order> getOrdersByAccount(String account) {

        return null;
    }

    public static void main(String[] args) {
        List<Order> orders = new OrderDAO().getOrdersByAccount("tomcat");
        System.out.println(orders);
    }
}
