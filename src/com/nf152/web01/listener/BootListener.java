package com.nf152.web01.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionListener;

public class BootListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 服务器启动的时候，要触发的逻辑
        System.out.println(">>> 欢迎您来到我的书店管理系统");
        System.out.println(">>>");
        System.out.println(">>> 如果您有任何问题，请联系 QQ: 110");
        System.out.println(">>>");
        System.out.println(">>> 如果想了解使用详情，请登录 http://wwww.baidu.com");
        System.out.println(">>> ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // 服务器关闭的时候，要触发的逻辑
        System.out.println("<<< 拜拜，欢迎您下次愉快归来。");
    }
}
