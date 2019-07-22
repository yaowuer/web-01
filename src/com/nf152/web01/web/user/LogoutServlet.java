package com.nf152.web01.web.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销，退出登录
 */

@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除登录凭证
        req.getSession().removeAttribute("account");

        // 返回首页
        resp.sendRedirect(req.getContextPath() + "/book/user/index");
    }
}
