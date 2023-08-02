package com.tjetc.dao;

import com.tjetc.entity.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int insert(Teacher teacher);
    int insertSC(@Param("tid") Integer tid, @Param("cid") Integer cid);

    Teacher queryById(Integer id);
    Teacher queryById2(Integer id);

}
