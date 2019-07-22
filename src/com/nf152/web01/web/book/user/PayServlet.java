package com.nf152.web01.web.book.user;

import com.nf152.web01.bean.Account;
import com.nf152.web01.dao.OrderDAO;
import com.nf152.web01.util.DBUtil;
import com.nf152.web01.bean.book.Cart;

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
        // 获取参数
        String receiver = req.getParameter("username");
        String telphone = req.getParameter("telphone");
        String addr = req.getParameter("province")
                + req.getParameter("city")
                + req.getParameter("addr_detail");

        // 获取其他数据
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String account = ((Account)req.getSession().getAttribute("account")).getUsername();

        // 数据入库
        String orderId = new OrderDAO().createOrder(cart, account, receiver, telphone, addr);

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
