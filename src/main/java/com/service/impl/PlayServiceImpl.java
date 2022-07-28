package com.service.impl;

import com.mapper.PlayMapper;
import com.pojo.Play;
import com.service.PlayService;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-11:16
 */
public class PlayServiceImpl implements PlayService {
    // 1.创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();
    @Override
    public Play[] selectAll() {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取PlayMapper对象
        final PlayMapper mapper = sqlSession.getMapper(PlayMapper.class);

        final Play[] plays = mapper.selectAll();

        // 关闭资源
        sqlSession.close();

        return plays;
    }

    @Override
    public Play[] selectById(int id) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取PlayMapper对象
        final PlayMapper mapper = sqlSession.getMapper(PlayMapper.class);

        final Play[] plays = mapper.selectById(id);

        // 关闭资源
        sqlSession.close();

        return plays;

    }

    @Override
    public void deleteById(int id) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取PlayMapper对象
        final PlayMapper mapper = sqlSession.getMapper(PlayMapper.class);

        mapper.deleteById(id);

        // 数据持久化
        sqlSession.commit();

        // 关闭资源
        sqlSession.close();
    }

    @Override
    public void addPlay(Play play) {
        // 2.获取sqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取Mapper对象
        final PlayMapper mapper = sqlSession.getMapper(PlayMapper.class);

        mapper.addPlay(play);

        // 4.数据持久化
        sqlSession.commit();

        // 5.关闭资源
        sqlSession.close();
    }

    @Override
    public void updatePlay(Play play) {
        // 2.获取SqlSession资源
        final SqlSession sqlSession = factory.openSession();

        // 3.获取PlayMapper对象
        final PlayMapper mapper = sqlSession.getMapper(PlayMapper.class);

        mapper.updatePlay(play);

        // 4.数据持久化
        sqlSession.commit();

        // 5.关闭资源
        sqlSession.close();
    }
}
