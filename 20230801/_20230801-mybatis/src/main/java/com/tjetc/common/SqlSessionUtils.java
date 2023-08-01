package com.tjetc.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtils {
    public static SqlSession getSqlSession() throws IOException {
//        创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        创建SqlSessionFactory对象，读取mybatis.xml文件并解析
        SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis.xml"));
//        创建SqlSession对象
        return factory.openSession();
    }
}
