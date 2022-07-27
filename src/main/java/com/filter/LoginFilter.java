package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-21:49*/




@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request =  (HttpServletRequest) servletRequest;
       // 1.判断session中是否有userid 、 username、 admin
        final HttpSession session = request.getSession();
        final Object userid = session.getAttribute("userid");
        final Object username = session.getAttribute("username");
        final Object admin = session.getAttribute("admin");


        // 判断访问资源路径是否和登录注册相关
        String[] urls = {"/index.html", "/timeLine.html", "/js/", "/css/", "/user/"};
        final String url = request.getRequestURI().toString();
        for(String u : urls){
            if(url.contains(u)){
                // 找到资源放行
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println("路径为：" + url + "已经放行！");
                return;
            }
        }

        // 2.判断user是否为null
        if(userid != null && username != null && admin != null){
            // 已登录，放行
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("已登录放行：" + url);
        }else{
            // 没有登录，跳转到登录页面
            request.setAttribute("login_msg", "您尚未登录！");
            System.out.println("未登录不放行：" + url);
            request.getRequestDispatcher("/index.html").forward(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
