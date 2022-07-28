package com.mapper;

import com.pojo.Play;
import org.apache.ibatis.annotations.*;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-11:13
 */
public interface PlayMapper {

    /**
     * 返回所有解析接口
     * @return 解决接口集合
     */
    @Select("select * from play")
    Play[] selectAll();

    /**
     * 根据用户id查看解析接口
     * @param id 用户id
     * @return 返回用户接口
     */

    @Select("select * from play where userId = #{id}")
//    @ResultMap("userId")
    Play[] selectById(@Param("id") int id);


    /**
     * 根据接口id 删除指定接口
     * @param id 接口id
     */
    @Delete("delete from play where id = #{id}")
    void deleteById(@Param("id") int id);

    /**
     * 注意此时的id为用户id，我们根据用户id进行添加相关信息
     * @param play 解析接口
     */
    @Insert("insert into play (userId, `name`, address) VALUES (#{play.userId}, #{play.name}, #{play.address})")
    void addPlay(@Param("play") Play play);

    /**
     * 根据接口id修改接口信息
     * @param play 接口
     */
    @Update("update play set  name = #{play.name}, address = #{play.address} where id = #{play.id}")
    void updatePlay(@Param("play") Play play);


    /**
     * 批量删除
     * @param ids 接口id集合
     */
    void deleteByIds(@Param("ids") int[] ids);






}
