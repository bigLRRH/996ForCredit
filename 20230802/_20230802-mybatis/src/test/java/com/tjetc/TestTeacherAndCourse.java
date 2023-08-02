package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.CourseMapper;
import com.tjetc.dao.TeacherMapper;
import com.tjetc.entity.Course;
import com.tjetc.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class TestTeacherAndCourse {
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//        添加三名老师

        Teacher t1 = new Teacher();
        t1.setName("张三");
        Teacher t2 = new Teacher();
        t2.setName("李四");
        Teacher t3 = new Teacher();
        t3.setName("王五");
        teacherMapper.insert(t1);
        teacherMapper.insert(t2);
        teacherMapper.insert(t3);
//        添加三名课程
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        Course c1 = new Course();
        c1.setName("JavaSE");
        Course c2 = new Course();
        c2.setName("JSP");
        Course c3 = new Course();
        c3.setName("SpringBoot");
        courseMapper.insert(c1);
        courseMapper.insert(c2);
        courseMapper.insert(c3);
//        添加SC表数据（老师选课程）
        teacherMapper.insertSC(t1.getId(), c1.getId());
        teacherMapper.insertSC(t1.getId(), c2.getId());
        teacherMapper.insertSC(t1.getId(), c3.getId());

        teacherMapper.insertSC(t2.getId(), c1.getId());
        teacherMapper.insertSC(t2.getId(), c2.getId());

        teacherMapper.insertSC(t3.getId(), c2.getId());
        teacherMapper.insertSC(t3.getId(), c3.getId());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testById() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.queryById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testById2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.queryById2(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
