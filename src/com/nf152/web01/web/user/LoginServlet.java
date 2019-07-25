package com.nf152.web01.web.user;

import com.nf152.web01.bean.Account;
import com.nf152.web01.util.CommonUtil;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 进行用户权限校验，即登录
 */

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 跳转到登录的 jsp，进行登录表单的渲染
        req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = DBUtil.queryOne(
                Account.class,
                "select username, password, type from account where username = ? and password = ?",
                username, password);

        if (account == null) {
            // 将错误信息保存在 request
            req.setAttribute("errMsg", "登录失败，请重试！");
            // 返回登录的 form 表单，重新登录
            req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
            return;
        } else {
            // 登录的时候，记录一下时间
            DBUtil.execute("update account set last_visit_time = ? where username = ?",
                    req.getSession().getAttribute("createdTime"),
                    account.getUsername());
            // 保存到 session 里
            req.getSession().setAttribute("account", account);
        }

        // 否则，返回首页，或者返回登录前的页面
        String back_url = req.getParameter("back_url");
        String return_url = req.getContextPath() + (back_url == null || back_url.isEmpty() ? "/" : back_url);
        resp.sendRedirect(return_url);
    }
}
