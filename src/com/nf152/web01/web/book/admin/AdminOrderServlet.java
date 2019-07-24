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

@WebServlet("/AdminOrder")
public class AdminOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Order> orders =  new OrderDAO().getOrderAll();
        request.setAttribute("orderk",orders);
        request.getRequestDispatcher("/WEB-INF/book/admin/adminorder.jsp").forward(request,response);
    }
}
