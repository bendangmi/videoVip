package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-17:17
 */
public class UserServiceImpl implements UserService {

    // 1.创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    @Override
    public User selectUser(User user) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final User selectUser = mapper.selectUser(user);

        // 4.关闭sqlSession
        sqlSession.close();

        return selectUser;
    }

    @Override
    public void addUser(User user) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 往数据库仍对象
        mapper.addUser(user);

        // 数据库持久化
        sqlSession.commit();

        // 4.关闭sqlSession
        sqlSession.close();
    }

    @Override
    public User selectUserName(User user) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final User selectUser = mapper.selectUserName(user);

        // 4.关闭sqlSession
        sqlSession.close();

        return selectUser;
    }

    @Override
    public User[] selectAll() {
        // 2. 获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        final User[] users = mapper.selectAll();

        // 关闭资源
        sqlSession.close();

        return users;


    }

    @Override
    public void deleteUserById(int id) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserById(id);

        // 数据持久化
        sqlSession.commit();

        // 关闭资源
        sqlSession.close();

    }

    @Override
    public void deleteUserByIds(int[] ids) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserByIds(ids);

        // 4.数据持久化
        sqlSession.commit();

        // 5.关闭资源
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        // 2.获取SqlSession对象
        final SqlSession sqlSession = factory.openSession();

        // 3.获取UserMapper对象
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(user);

        // 4.数据持久化
        sqlSession.commit();

        // 5.关闭资源
        sqlSession.close();
    }
}
