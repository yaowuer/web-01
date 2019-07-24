package com.nf152.web01.web.book.admin;

import com.nf152.web01.bean.book.Order;
import com.nf152.web01.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/admin/orderManger")
public class OrderMangerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderDAO orderDAO = new OrderDAO();
        List<Order> validOrders = orderDAO.getOrdersByStatus(2);

        req.setAttribute("orders", validOrders);
        req.getRequestDispatcher("/WEB-INF/book/admin/orderList.jsp").forward(req, resp);
    }
}
