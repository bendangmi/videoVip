package com.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.pojo.Login;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-17:39
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    /**
     * 登录验证、注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final BufferedReader reader = request.getReader();

        final String readLine = reader.readLine();

        System.out.println(readLine);
        // 数据转JSON
        final User user = JSON.parseObject(readLine, User.class);
        System.out.println(user);

        final User selectUser = userService.selectUser(user);

        Login login = null;
        // 如果type == login 为登录 ，type == register 为注册
        if(selectUser == null){
            final User name = userService.selectUserName(user);

            if ("register".equals(user.getType()) && name == null) {
                System.out.println("注册");
                user.setAdmin("0");

                // 注册操作
                userService.addUser(user);

                // 注册操作 注册成功后返回一个id
                User user1 = userService.selectUser(user);
                if(user1 != null){
                    System.out.println("注册成功！");
                    // 设置session 如果已登录，返回用户id，用户名，用户是否为管理员给前端
                    final HttpSession session = request.getSession();
                    session.setAttribute("userid", user1.getId());
                    session.setAttribute("username", user1.getName());
                    session.setAttribute("admin",0);
                    login = new Login("0", "0", user1.getId(), user.getName());
                }else{
                    System.out.println("数据库的相关问题！");
                }

            }else if("login".equals(user.getType())){
                System.out.println("密码错误");
                login = new Login("-3", "-1", -1, "-1");
            }else{
                // 用户已存在
                System.out.println("用户已经存在！");
                login = new Login("-2", "-1", -1, "-1");
            }

        }else{
            if ("login".equals(user.getType())) {
                login = new Login("1", selectUser.getAdmin(), selectUser.getId(), selectUser.getName());
                System.out.println("登录验证成功！");
                System.out.println(selectUser);
                System.out.println(login);

                // 设置session 如果已登录，返回用户id，用户名，用户是否为管理员给前端
                final HttpSession session = request.getSession();
                session.setAttribute("userid", selectUser.getId());
                session.setAttribute("username", selectUser.getName());
                session.setAttribute("admin",selectUser.getAdmin());

                // 创建Cookie对象
                /*
                final Cookie username = new Cookie("username", URLEncoder.encode(user.getUserName(), "UTF-8") );
                final Cookie password = new Cookie("password", URLEncoder.encode(user.getPassword(), "UTF-8"));

                // 设置存活时间
                username.setMaxAge(60 * 60 * 24);
                password.setMaxAge(60 * 60 * 24);

                // 发送Cookie
                response.addCookie(username);
                response.addCookie(password);*/

            }else{
                System.out.println("非法操作！");
            }
        }

        // 如果数据中存在中文，需要设置编码
        response.setContentType("text/json;charset=utf-8");
        final String jsonString = JSON.toJSONString(login);
        response.getWriter().write(jsonString);

    }

    /**
     * 保持登录状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void status(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        final Object userid = session.getAttribute("userid");
        final Object username = session.getAttribute("username");
        final Object admin = session.getAttribute("admin");
        if(userid != null && username != null && admin != null){
            // 已登录  返回用户名 和 用户id
            final Login login = new Login("1", (String) admin, (Integer) userid, (String) username);
            final String jsonString = JSON.toJSONString(login);
            // 如果数据中存在中文，需要设置编码
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }else{
            // 未登录
            response.getWriter().write("noSuccess");
        }
    }




    @Test
    public void selectUser() {
        final UserServiceImpl userService1 = new UserServiceImpl();
        final User user = userService1.selectUserName(new User("本当迷", "Abc1"));
        System.out.println(user);
    }

}
