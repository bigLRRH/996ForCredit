package com.ew.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RestMapper {
    List<Map<String, Object>> getAll(@Param("tableName") String tableName);

    //    List<Object> query(@Param("tableName") String tableName,@Param("inf")String inf);
    Map<String, Object> getById(@Param("tableName") String tableName, @Param("id") Long id);

    Integer insert(@Param("tableName") String tableName, @Param("columnMap") Map<String, Object> columnMap);

    Integer update(@Param("tableName") String tableName, @Param("id") Long id, @Param("columnMap") Map<String, Object> columnMap);

    Integer deleteById(@Param("tableName") String tableName, @Param("id") Long id);

}
