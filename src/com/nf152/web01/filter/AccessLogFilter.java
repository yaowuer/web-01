package com.nf152.web01.filter;

import com.nf152.web01.bean.Account;
import com.nf152.web01.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Account account = (Account) request.getSession().getAttribute("account");

        if (account != null) {
            DBUtil.execute("insert into access_log (account, ip, ua, url, access_at) values (?, ?, ?, ?, ?)",
                    account.getUsername(),
                    request.getRemoteAddr(),
                    request.getHeader("user-agent"),
                    request.getRequestURI(),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        // 将请求传递给下一个 Filter，如果没有 filter了，那么执行相关 servlet 里的逻辑
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
