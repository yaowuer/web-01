package com.nf152.web01.web.book.user;

import com.nf152.web01.web.book.user.bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book/user/delFromCart")
public class CartDelServlet extends HttpServlet {
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

        resp.sendRedirect(req.getContextPath() + "/book/user/index?showCart=1");
    }
}
