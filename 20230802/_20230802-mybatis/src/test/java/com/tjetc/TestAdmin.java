package com.tjetc;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.AdminMapper;
import com.tjetc.entity.Admin;
import com.tjetc.enums.EnumSex;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestAdmin {
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setUsername("jim");
        admin.setPassword("88888");
        admin.setSex(EnumSex.MALE);
        mapper.insert(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryById() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.queryById(1);
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void testQueryList() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> list = mapper.queryList();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testQueryListForPages() throws IOException{
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
//        设置页码和每页数量
        PageHelper.startPage(1,2);
        List<Admin> admins = mapper.queryList();
        PageInfo pageAdmins = new PageInfo(admins);
        System.out.println(admins);
        System.out.println(pageAdmins);
        sqlSession.close();
    }
}
