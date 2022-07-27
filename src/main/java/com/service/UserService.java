package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-17:18
 */
public interface UserService {
    /**
     * 查找用户是否存在
     * @param user 前端传来的user对象
     * @return 返回数据库中用户信息，没有返回空
     */
    User selectUser(User user);

    /**
     * 添加用户
     * @param user 前端传来的user对象
     */
    void addUser( User user);

    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    User selectUserName(User user);
}
