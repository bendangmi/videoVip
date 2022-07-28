package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-17:17
 */
public interface UserMapper {

    /**
     *  查找用户是否存在，用于登录校验，注册校验
     * @param user 前端传入的user对象
     * @return 返回一个用户对象，为null表示用户不存在
     */
    @Select("select * from user where name= #{user.name} and password = #{user.password}")
    User selectUser(@Param("user")User user);

    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    @Select("select * from user where name= #{user.name}")
    User selectUserName(@Param("user")User user);

    @Insert("insert into user (id, name, password, admin) values (#{user.id}, #{user.name}, #{user.password}, #{user.admin})")
    void addUser(@Param("user") User user);

    /**
     * 查看所有用户
     * @return 返回用户数组
     */
    @Select("select * from user")
    User[] selectAll();

    /**
     * 根据用户id删除指定用户
     * @param id 用户id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUserById(@Param("id") int id);

    /**
     * 根据用户id数组批量删除用户
     * @param ids 用户数组
     */

    void deleteUserByIds(@Param("ids") int[] ids);

    /**
     * 修改用户密码
     * @param user 用户
     */
    @Update("update user set name = #{user.name}, password = #{user.password}, admin = #{user.admin} where id = #{user.id}")
    void updateUser(@Param("user") User user);

}
