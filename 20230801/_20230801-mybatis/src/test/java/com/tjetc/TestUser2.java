package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.UserMapper;
import com.tjetc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestUser2 {
    @Test
    public void testQueryByUser() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("jim");
        List<User> users = mapper.queryListByUser(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testQueryByUser2() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> users = mapper.queryListByUser2(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testQueryByUser3() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> users = mapper.queryListByUser3(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testQueryByUser4() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> users = mapper.queryListByUser4(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void updateByUser() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        int rows = mapper.updateByUser(user);
        System.out.println(rows);
        sqlSession.close();
    }

    @Test
    public void testQueryListForList() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        参数是集合
        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L);
        List<User> users = mapper.queryListForList(ids);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testQueryListForArray() throws IOException {
        //        创建SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //        获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        参数是集合
        Long[] ids = {1L, 2L, 3L, 4L};
        List<User> users = mapper.queryListForArray(ids);
        System.out.println(users);
        sqlSession.close();
    }
}
