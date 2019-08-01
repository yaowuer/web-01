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
        List<Task> tasks = DBUtil.queryList(Task.class, "select * from task");

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
