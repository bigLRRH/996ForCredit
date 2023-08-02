package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.MyClassMapper;
import com.tjetc.dao.StudentMapper;
import com.tjetc.entity.MyClass;
import com.tjetc.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class TestMyClassAndStudent {

    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = new MyClass();
        myClass.setName("班级1");
        myClassMapper.insert(myClass);

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student s1 = new Student();
        s1.setName("张三");
        s1.setMyClass(myClass);
        Student s2 = new Student();
        s2.setName("李四");
        s2.setMyClass(myClass);

        studentMapper.insert(s1);
        studentMapper.insert(s2);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryById() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = myClassMapper.queryById(1);
        System.out.println(myClass);
        sqlSession.close();
    }

    @Test
    public void testQueryById2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MyClassMapper myClassMapper = sqlSession.getMapper(MyClassMapper.class);
        MyClass myClass = myClassMapper.queryById2(1);
        System.out.println(myClass);
        sqlSession.close();
    }
}
