package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 查看所有用户
     * @return 返回用户数组
     */
    User[] selectAll();

    /**
     * 根据用户id删除指定用户
     * @param id 用户id
     */
    void deleteUserById(int id);

    /**
     * 根据用户id数组批量删除用户
     * @param ids 用户数组
     */

    void deleteUserByIds(int[] ids);

    /**
     * 修改用户密码
     * @param user 用户
     */
    void updateUser( User user);

}
