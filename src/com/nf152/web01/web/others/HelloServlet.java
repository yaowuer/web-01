package com.nf152.web01.web.others;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletOutputStream outputStream = res.getOutputStream();
        PrintWriter writer = resp.getWriter();
        writer.println("Hello, World");
    }
}
