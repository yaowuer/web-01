package com.nf152.web01.web.book.user;

import com.nf152.web01.util.DBUtil;
import com.nf152.web01.util.OrderUtil;
import com.nf152.web01.web.book.user.bean.Cart;
import com.nf152.web01.web.book.user.bean.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/book/user/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String telphone = req.getParameter("telphone");
        String addr = req.getParameter("province")
                + req.getParameter("city")
                + req.getParameter("addr_detail");

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        // 将这个交易请求，保存到数据库
        // 订单信息
        String orderId = OrderUtil.getOrderId();
        String sql = "insert into dingdan (id, username, phone, addr, create_at, status) values (?, ?, ?, ?, ?, ?)";
        DBUtil.execute(sql,
                orderId,
                userName,
                telphone,
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

        // 清空购物车
        cart.clear();

        req.setAttribute("orderId", orderId);

        // 通过相关的 API 调用微信的支付接口，获取支付的二维码图片

        req.getRequestDispatcher("/WEB-INF/book/user/4-pay.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderid");

        DBUtil.execute("update dingdan set status = 2 where id = ?", orderId);

        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath() + "/book/user/paySuccess");
    }
}
