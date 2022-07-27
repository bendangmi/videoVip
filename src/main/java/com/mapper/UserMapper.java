package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
