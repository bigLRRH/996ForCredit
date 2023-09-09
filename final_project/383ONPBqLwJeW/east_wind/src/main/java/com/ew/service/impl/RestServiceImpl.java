package com.ew.service.impl;

import com.ew.common.response.JsonResult;
import com.ew.dao.RestMapper;
import com.ew.enums.ResourceMapping;
import com.ew.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestServiceImpl implements RestService {
    @Autowired
    RestMapper restMapper;

    @Override
    public JsonResult<List<Map<String, Object>>> getAll(String resourceName) {
//        todo remove log
        System.out.println("resourceName:" + resourceName);
//        todo 字符串优化
        resourceName = String.format("`%s`", resourceName);
        List<Map<String, Object>> data = restMapper.getAll(resourceName);
//        todo remove log
        System.out.println("data:" + data);
        if (data.isEmpty()) {
            return new JsonResult<>(0, "Resource not found", null);
        } else {
            return new JsonResult(0, "success", data);
        }
    }

//    @Override
//    public ResponseEntity<JsonResult<List<?>>> query(String resourceName, Object inf) {
//        try{
//            String className = ResourceMapping.getResourceMapping(resourceName).getClassName();
//            Class c=  Class.forName(className);
//
//        }catch (ClassNotFoundException e){
//
//        }
//        resourceName = String.format("`%s`", resourceName);
//
//        return null;
//    }

    @Override
    public JsonResult<Map<String, Object>> getById(String resourceName, Long id) {
        resourceName = String.format("`%s`", resourceName);
        Map<String, Object> obj = restMapper.getById(resourceName, id);
        if (obj == null) {
            return new JsonResult<>(0, "Resource not found", null);
        }
        return new JsonResult<>(0, "success", obj);
    }

    @Override
    public JsonResult<Integer> create(String resourceName, Map<String, Object> data) {
        resourceName = String.format("`%s`", resourceName);
        Integer rowsChanged = restMapper.insert(resourceName, data);
        if (rowsChanged > 0) {
            return new JsonResult<>(0, "success", rowsChanged);
        } else {
            return new JsonResult<>(1, "Creation failed", null);
        }
    }

    @Override
    public JsonResult<Integer> update(String resourceName, Long id, Map<String, Object> data) {
        resourceName = String.format("`%s`", resourceName);
        Map<String, Object> storedData = restMapper.getById(resourceName, id);
        if (storedData == null) {
            return new JsonResult<>(0, "Resource not found", null);
        }

        Integer rowsChanged = restMapper.update(resourceName, id, data);

        if (rowsChanged > 0) {
            return new JsonResult<>(0, "success", rowsChanged);
        } else {
            return new JsonResult<>(1, "Update failed", null);
        }
    }

    @Override
    public JsonResult<Integer> deleteById(String resourceName, Long id) {
        resourceName = String.format("`%s`", resourceName);
        Map<String, Object> storedData = restMapper.getById(resourceName, id);
        if (storedData == null) {
            return new JsonResult<>(0, "Resource not found", null);
        }
        Integer rowsChanged = restMapper.deleteById(resourceName, id);
        if (rowsChanged > 0) {
            return new JsonResult<>(0, "success", rowsChanged);
        } else {
            return new JsonResult<>(1, "Delete failed", null);
        }
    }
}
