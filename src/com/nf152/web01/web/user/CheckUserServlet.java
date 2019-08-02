package com.nf152.web01.web.user;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/user/checkUser")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        List<Map<String, Object>> maps = DBUtil.queryForMap("select 1 from account where username = ?", username);

        if (maps == null || maps.size() < 1) {
            resp.getWriter().write("ok");
        } else {
            resp.getWriter().write("err");
        }
    }
}
