package com.nf152.web01.dao;

import com.nf152.web01.bean.Account;
import com.nf152.web01.bean.book.Book;
import com.nf152.web01.bean.book.Order;
import com.nf152.web01.util.DBUtil;
import com.nf152.web01.util.OrderUtil;
import com.nf152.web01.bean.book.Cart;
import com.nf152.web01.bean.book.CartItem;
import org.sqlite.core.DB;

import java.text.SimpleDateFormat;
import java.util.*;

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
        // 1. 查询订单
        String sql1 = "select id, receiver, phone, addr, status from dingdan where account = ?";
        String sql2 = "select a.* from account a join dingdan d on a.username = d.account where d.id = ?";
        String sql3 = "select b.*, d.amount shumu from dingdan_xijie d join book b on d.bookid = b.id where ddid = ?";

        List<Order> orders = DBUtil.queryList(Order.class, sql1, account);

        for (Order order : orders) {
            String id = order.getId();

            // 设置订单的账号
            order.setAccount(DBUtil.queryOne(Account.class, sql2, id));

            // 获取并设置订单的细节
            List<Map<String, Object>> maps = DBUtil.queryForMap(sql3, id);
            Map<Book, Integer> orderDetail = new HashMap<>();
            // 接下来，将 maps 中的数据，转换到 orderDetail 结构中
            for (Map<String, Object> map : maps) {
                // 订单详情中的书籍
                Book book = new Book();
                book.setId((Integer) map.get("id"));
                book.setName((String) map.get("name"));
                book.setAuthor((String) map.get("author"));
                book.setPublisher((String) map.get("publisher"));
                book.setPrice((Double) map.get("price"));
                book.setAmount((Integer) map.get("amount"));
                book.setPublishAt((String) map.get("publishAt"));

                // 订单详情中的数目
                Integer amount = (Integer) map.get("shumu");

                // 将当前订单详情数据添加到 orderDetail
                orderDetail.put(book, amount);
            }
            // 设置到当前订单
            order.setOrderDetail(orderDetail);
        }
        return orders;
    }

    public static void main(String[] args) {
        List<Order> orders = new OrderDAO().getOrdersByAccount("tomcat");
        System.out.println(orders);
    }
}
