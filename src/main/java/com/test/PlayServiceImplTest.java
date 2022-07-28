package com.test;

import com.pojo.Play;
import com.service.impl.PlayServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-13:02
 */
class PlayServiceImplTest {
    private final PlayServiceImpl playService =  new PlayServiceImpl();

    /**
     * 查看所有接口
     */
    @Test
    void selectAll() {
        final Play[] plays = playService.selectAll();
        for (Play p :
                plays) {
            System.out.println(p);
        }
    }

    /**
     * 根据接口用户id查看接口信息
     */
    @Test
    void selectById() {
        final Play[] plays = playService.selectById(1);
        for (Play p :
                plays) {
            System.out.println(p);
        }
    }

    /**
     * 根据指定id删除解析
     */
    @Test
    void deleteById() {
        playService.deleteById(11);
    }

    /**
     * 添加解析
     */
    @Test
    void addPlay() {
        final Play play = new Play(2, 2, "本当迷解析", "https:www.bdmcom.cn");
        playService.addPlay(play);
    }

    @Test
    void updatePlay() {
        final Play play = new Play(2, 4, "本当迷解析", "https:www.bdmcom.cn");
        playService.updatePlay(play);
    }
}