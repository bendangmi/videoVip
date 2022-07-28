package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Play;
import com.service.PlayService;
import com.service.impl.PlayServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-11:27
 */
@WebServlet("/play/*")
public class PlayServlet extends BaseServlet{
    PlayService playService = new PlayServiceImpl();
    public void updatePlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取post请求中的Play对象
        final String readLine = request.getReader().readLine();
        final Play play = JSON.parseObject(readLine, Play.class);

        System.out.println(play);

        // 2.修改play数据
        playService.updatePlay(play);

        // 3.响应成功消息
        response.getWriter().write("success");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取全部接口
        final Play[] plays = playService.selectAll();

        // 2.对象转JSON
        final String jsonString = JSON.toJSONString(plays);

        // 3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取接口id
        final String id = request.getParameter("id");

        // 2.删除指定接口
        playService.deleteById(Integer.parseInt(id));

        // 3.响应成功信息
        response.getWriter().write("success");
    }

    public void addPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取接口名称、地址、用户id
        String playName = new String(request.getParameter("inputPlayName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        String playName = request.getParameter("inputPlayName");
        final String id = request.getParameter("id");
        final String playUrl = request.getParameter("inputPlayUrl");
        System.out.println(id + " " + playName + " " + playUrl);
        final Play play = new Play(Integer.parseInt(id), playName, playUrl);

        System.out.println(play);

        playService.addPlay(play);

        response.getWriter().write("success");
    }

    public void selectPlayById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接受get请求中传来的用户id，查找用户的解析接口
        System.out.println("**************************");
        final String id = request.getParameter("id");
        System.out.println("用户id" + id);
        final Play[] plays = playService.selectById(Integer.parseInt(id));

        // 对象转JSON
        final String jsonString = JSON.toJSONString(plays);

        // 响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);


    }
}


