package com.nf152.web01.web.book.user;

import com.nf152.web01.web.book.user.bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        // 通过相关的 API 调用微信的支付接口，获取支付的二维码图片

        req.getRequestDispatcher("/WEB-INF/book/user/4-pay.jsp").forward(req, resp);
    }
}
