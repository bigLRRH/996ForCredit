package com.tjetc.dao;

import com.tjetc.entity.IdCard;

public interface IdCardMapper {
    int insert(IdCard idCard);
    IdCard queryById(Integer id);
    IdCard queryById2(Integer id);
}
