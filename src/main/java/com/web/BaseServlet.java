package com.web;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/24-20:24
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换HttpServlet, 根据请求的最后一段路径来进行分发
 */
public class BaseServlet extends HttpServlet {

    // 根据请求的最后一段路径来进行分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求路径
        final String uri = req.getRequestURI();

        // 2.获取最后一段路径，方法名
        final int index = uri.lastIndexOf('/');
        final String methodName = uri.substring(index + 1);

        // 3.执行方法
        // 3.1获取BrandServlet / UserServlet 字节码对象 Class
        final Class<? extends BaseServlet> aClass = this.getClass();

        // 3.3获取方法Method对象
        try {
            final Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 3.4执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}

