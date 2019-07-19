package com.nf152.web01.web.book.user;

import com.nf152.web01.bean.Account;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/user/lstOrder")
public class OrderLstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 如果不能从 session 中获取登录凭证，
        // 说明没有登录，那么跳转到登录页面，进行登录
        if (req.getSession().getAttribute("account") == null) {
            // 可以添加 back_url 参数，让登录的逻辑处理，以便登录完毕能跳转回来
            resp.sendRedirect(req.getContextPath() + "/user/login?back_url=" + "/book/user/lstOrder");
            return;
        }

        // 获取用户信息
        Account account = (Account) req.getSession().getAttribute("account");
        String username = account.getUsername();

        // 查询订单

        // 在 JSP 中渲染订单
        req.getRequestDispatcher("/WEB-INF/book/user/6-listOrder.jsp").forward(req, resp);
    }
}
