package com.nf152.web01.web.book.user;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/user/doCheck")
public class OrderCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // 必须在做相关修改前，进行进一步确认
        // 务必保证你的修改是正确的
//        if (Integer.valueOf(id) != 3) {
//            // 挑战到错误页面，或者给出错误提示。
//            return;
//        }

        DBUtil.execute("update dingdan set status = 4 where id = ?", id);
        resp.sendRedirect(req.getContextPath() + "/book/user/lstOrder");
    }
}
