package com.nf152.web01.web.book.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book/delFromCart")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (id == -1) { // 清空
            cart.clear();
        } else {
            cart.remove(id);
        }

        resp.sendRedirect(req.getContextPath() + "/book/index?showCart=1");
    }
}
