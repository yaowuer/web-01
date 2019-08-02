package com.nf152.web01.web.ajax;

import com.nf152.web01.bean.Task;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/ajax/task")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("application/json;charset=UTF8");

        List<Task> tasks = DBUtil.queryList(Task.class, "select * from task");

        // 手动拼接 JSON 字符串很费劲是吧？
        // 那么你需要知道的是：
        // - Java 那么流行，最重要的原因是生态巨好
        // - 所谓的生态好的意思是: 有很多第三方 jar 包可以帮助你轻松将对象转换成 JSON 字符串
        //
        // 比如说，流行的 Gson/fastjson/jackson
        // - Gson 是 Google 出产，用的比较广泛
        // - fastjson 是阿里出产，吹牛逼说自己是最快最好，实质一般般
        // - jackson 老牌经典，速度快效率高功能全，就是 API 不是那么好用
        //
        // 怎么用，自行了解

        StringBuilder sb = new StringBuilder();

        for (Task task : tasks) {
            if (sb.length() > 0) sb.append(",");

            sb.append(
                    String.format("{\"id\": \"%s\", \"content\": \"%s\", \"status\": \"%s\"}",
                            task.getId(), task.getContent(), task.getStatus())
            );
        }

        resp.getWriter().write("[" + sb.toString() + "]");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");

        int id = DBUtil.insertWithLastId("insert into task (content, status) values (?, ?)",
                content, "1");

        resp.getWriter().print(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DBUtil.execute("update task set status = '9' where id = ?", id);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DBUtil.execute("delete from task where id = ?", id);
    }
}
