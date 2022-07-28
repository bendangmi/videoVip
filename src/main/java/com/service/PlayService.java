package com.service;

import com.pojo.Play;
import org.apache.ibatis.annotations.Param;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-11:15
 */
public interface PlayService {

    /**
     * 返回所有解析接口
     * @return 解决接口集合
     */

    Play[] selectAll();

    /**
     * 根据用户id查看解析接口
     * @param id 用户id
     * @return 返回用户接口
     */

    Play[] selectById(@Param("id") int id);


    /**
     * 根据id 删除指定接口
     * @param id 接口id
     */
    void deleteById(@Param("id") int id);

    /**
     * 注意此时的id为用户id，我们根据用户id进行添加相关解析接口
     * @param play 解析接口
     */
    void addPlay(@Param("play") Play play);


    /**
     * 根据接口id修改接口信息
     * @param play 接口
     */

    void updatePlay(@Param("play") Play play);


}
