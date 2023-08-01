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
}
