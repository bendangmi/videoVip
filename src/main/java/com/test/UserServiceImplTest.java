package com.test;

import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-13:01
 */
class UserServiceImplTest {

    private final UserServiceImpl userService = new UserServiceImpl();

    /**
     * 校验用户登录
     */
    @Test
    void selectUser() {
        final User user = new User("本当迷", "Abc12345678");
        final User user1 = userService.selectUser(user);
        System.out.println(user1);
    }

    /**
     * 添加用户，用户注册
     */
    @Test
    void addUser() {
        final User user = new User("本当迷9", "Abc123", "1");
        userService.addUser(user);

    }

    /**
     * 根据用户名查找用户信息
     */
    @Test
    void selectUserName() {
        final User user = new User("本当迷");
        final User user1 = userService.selectUserName(user);
        System.out.println(user1);
    }

    /**
     * 查找所有用户
     */
    @Test
    void selectAll() {
        final User[] users = userService.selectAll();
        for (User u :
                users) {
            System.out.println(u);
        }
    }

    /**
     * 根据id删除指定用户
     */
    @Test
    void deleteUserById() {
        userService.deleteUserById(15);

    }

    /**
     * 批量删除用户
     */
    @Test
    void deleteUserByIds() {
        int[] arr = {12, 13};
        userService.deleteUserByIds(arr);

    }

    /**
     * 修改用户信息
     */
    @Test
    void updateUser() {
        final User user = new User("本当迷5", "Abc", 29, "1");
        userService.updateUser(user);
    }
}