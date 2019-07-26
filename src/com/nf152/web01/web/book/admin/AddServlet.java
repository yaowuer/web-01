package com.nf152.web01.web.book.admin;

import com.nf152.web01.util.CommonUtil;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@WebServlet("/book/admin/add")
@MultipartConfig
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取添加的页面
        req.getRequestDispatcher("/WEB-INF/book/admin/bookAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 提交保存数据
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer amount = Integer.valueOf(req.getParameter("amount"));
        String publishAt = req.getParameter("publishat");

        Part cover = req.getPart("cover");

        // 保存到某个位置
        String filePath = "/upload/" + CommonUtil.fmtTime2(new Date()) + "_" + cover.getSubmittedFileName();
        String destPath = req.getServletContext().getRealPath("/") +filePath;

        // 确保文件夹存在
        new File(destPath).getParentFile().mkdir();

        cover.write(destPath); // 写绝对路径

        DBUtil.execute(
                "insert into book (name, author, publisher, price, amount, publish_at, cover) values (?, ?, ?, ?, ?, ?, ?)",
                name, author, publisher, price, amount, publishAt, filePath);

        resp.sendRedirect(req.getContextPath() + "/book/admin/manage");   // 重定向，肯定是 GET 方法
    }
}
