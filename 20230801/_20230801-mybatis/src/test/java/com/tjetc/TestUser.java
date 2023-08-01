package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.UserMapper;
import com.tjetc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class TestUser {
    //    Test注解表示 测试的方法
    @Test
    public void testQueryList() throws IOException {
//        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        调用userMapper对象的QueryList方法
        List<User> users = mapper.queryList();
//        打印结果集
        System.out.println(users);
//        关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testQueryById() throws IOException {
//        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        调用userMapper对象的QueryList方法
        User user = mapper.queryById(1L);
//        打印结果集
        System.out.println(user);
//        关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
//        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("laoli");
        user.setPassword("555555");
//        调用userMapper对象的insert方法
        mapper.insert(user);
//        增删改 都要手动提交事务
        sqlSession.commit();
//        打印结果集
        System.out.println(user.getId());
//        关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        获取更新对象
        User user = mapper.queryById(1L);
        user.setPassword("999999");
//        更新
        int rows = mapper.update(user);
        if (rows > 0) {
            sqlSession.commit();
            System.out.println("更新成功");
        } else {
            sqlSession.rollback();
            System.out.println("更新失败");
        }

        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int rows = mapper.delete(6L);
        if (rows > 0) {
            System.out.println("删除成功");
            sqlSession.commit();
        } else {
            System.out.println("删除失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
