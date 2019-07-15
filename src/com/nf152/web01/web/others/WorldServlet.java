package com.nf152.web01.web.others;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WorldServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让 Servlet 将所有字符串解析为 UTF-8 响应给客户端
        resp.setCharacterEncoding("UTF-8");
        // 向客户端暗示，需要将返回的内容解析为 html，并且告诉客户端需要使用 utf8 编码解析
        resp.setContentType("text/html;charset=utf8");

        // 打开一个响应的“流”，即架设一个管道，将内容输送给客户端的浏览器
        PrintWriter writer = resp.getWriter();

        // 内容输送开始
        writer.println("<html>");
        writer.println("<h1>");
        writer.println("hello, world!");
        writer.println("</h1>");
        writer.println("<pre style='background: aliceblue; padding: 1em;'>");

        // 打开一个文件流，从文件中读取内容
        // 然后，将文件中的内容，写入到响应的流中，即显示在页面上
        BufferedReader reader = new BufferedReader(new FileReader("e:/aaa.txt"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            writer.println(line);
        }
        reader.close();

        // 继续输送其他内容
        writer.println("</pre>");
        writer.println("<script>console.log(666);</script>");
        writer.println("</html>");
    }
}
