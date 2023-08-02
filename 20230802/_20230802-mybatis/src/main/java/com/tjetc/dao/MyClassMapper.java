package com.tjetc.dao;

import com.tjetc.entity.MyClass;

public interface MyClassMapper {
    int insert(MyClass myClass);

    MyClass queryById(Integer id);
    MyClass queryById2(Integer id);
}
