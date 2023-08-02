package com.tjetc.dao;

import com.tjetc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //    查询所有的用户，返回List集合，集合中每个元素是User对象
    List<User> queryList();

    //    根据id查找
    User queryById(Long id);

    //    insert
    int insert(User user);

    //    update
    int update(User user);

    int delete(Long id);

    //    一个实现三种sql
    //    select * from `user`where `username`= 'jim' and`password`='123456";
//    select * from `user`where `password`="4444";
//    select * from `user`where `username`='jim';
    List<User> queryListByUser(User user);

    List<User> queryListByUser2(User user);

    List<User> queryListByUser3(User user);

    List<User> queryListByUser4(User user);

    int updateByUser(User user);

    //    参数是集合
    List<User> queryListForList(List<Long> ids);

    //    参数是数组
//    mybatis中接口方法不能重载，也就是在接口中方法名称都是唯一的
    List<User> queryListForArray(Long[] ids);

    List<User> queryListForMap(Map<String,Object> ids);

    List<User>queryList5(@Param("username") String username1, @Param("ids") Long[] ids1);

}
