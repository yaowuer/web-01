package com.nf152.web01.web.book.admin;

import com.nf152.web01.bean.book.Book;
import com.nf152.web01.bean.book.Order;
import com.nf152.web01.dao.OrderDAO;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dingdanxiangqing")
public class Dingdanxiangqing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        // 获取当前订单编号下的所有商品ID
        OrderDAO o = new OrderDAO();
        List<Order> orders = o.getOrdersByDdid(id);
        req.setAttribute("orderrr",orders);
        req.getRequestDispatcher("/WEB-INF/book/admin/bookorder.jsp").forward(req,resp);
    }
}
