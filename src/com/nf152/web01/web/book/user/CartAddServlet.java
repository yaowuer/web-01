package com.nf152.web01.web.book.user;

import com.nf152.web01.bean.book.Book;
import com.nf152.web01.util.DBUtil;
import com.nf152.web01.bean.book.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book/user/addCart")
public class CartAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        // 将此 ID 的图书，添加到购物车
        HttpSession session = req.getSession();

        // 更新保存在 cart 中的值
        Book book = DBUtil.queryOne(Book.class, "select * from book where id=?", id);

        // 首先，获取 session 中保存的购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.add(book, 1);

        session.setAttribute("cart", cart);

        // resp.sendRedirect(req.getContextPath() + "/book/user/index");
    }

}
