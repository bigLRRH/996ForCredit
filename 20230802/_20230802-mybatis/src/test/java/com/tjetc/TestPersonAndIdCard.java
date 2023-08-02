package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.dao.IdCardMapper;
import com.tjetc.dao.PersonMapper;
import com.tjetc.entity.IdCard;
import com.tjetc.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class TestPersonAndIdCard {
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("张三");

        personMapper.insert(person);
        System.out.println(person.getId());

        IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
        IdCard idCard = new IdCard();
        idCard.setCode("12315151555");
        idCardMapper.insert(idCard);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testQueryByCardId() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
        IdCard idCard=idCardMapper.queryById(1);
        System.out.println(idCard);
        sqlSession.close();
    }

    @Test
    public void testQueryByCardId2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        IdCardMapper idCardMapper = sqlSession.getMapper(IdCardMapper.class);
        IdCard idCard=idCardMapper.queryById2(1);
        System.out.println(idCard);
        sqlSession.close();
    }
}
