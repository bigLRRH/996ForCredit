package com.ew.service;

import com.ew.common.response.JsonResult;

import java.util.List;
import java.util.Map;

public interface RestService {
    JsonResult<List<Map<String, Object>>> getAll(String resourceName);

    //    JsonResult<List<?>> query(String resourceName, Object inf);
    JsonResult<Map<String, Object>> getById(String resourceName, Long id);

    JsonResult<Integer> create(String resource, Map<String, Object> data);

    JsonResult<Integer> update(String resource, Long id, Map<String, Object> data);

    JsonResult<Integer> deleteById(String resource, Long id);
}