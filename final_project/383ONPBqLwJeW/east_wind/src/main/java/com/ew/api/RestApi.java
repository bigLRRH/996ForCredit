package com.ew.api;

import com.ew.common.response.JsonResult;
import com.ew.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestApi {
    @Autowired
    RestService restService;

    private <T> ResponseEntity<JsonResult<T>> result(JsonResult<T> jsonResult, HttpStatus successStatus) {
        switch (jsonResult.getState()) {
            case 0:
                switch (jsonResult.getMsg()) {
                    case "Resource not found":
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResult);
                    default:
                        return ResponseEntity.status(successStatus).body(jsonResult);
                }
            case 1:
                switch (jsonResult.getMsg()) {
                    case "Update failed":
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResult);
                    default:
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResult);
                }
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResult);
        }
    }

    private <T> ResponseEntity<JsonResult<T>> result(JsonResult<T> jsonResult) {
        return result(jsonResult, HttpStatus.OK);
    }

    @GetMapping("/rest/{permission}/{resource}")
    public ResponseEntity<JsonResult<List<Map<String, Object>>>> getAll(@PathVariable("resource") String resource) {
        System.out.println("\033]32mRestApi getAll() called\033]0m");
        JsonResult<List<Map<String, Object>>> jsonResult = restService.getAll(resource);
        return result(jsonResult);
    }

    @GetMapping("/rest/{permission}/{resource}/{id}")
    public ResponseEntity<JsonResult<Map<String, Object>>> getById(@PathVariable("resource") String resource, @PathVariable("id") Long id) {
        JsonResult<Map<String, Object>> jsonResult = restService.getById(resource, id);
        return result(jsonResult);
    }

    @PostMapping("/rest/{permission}/{resource}")
    public ResponseEntity<JsonResult<Integer>> create(@PathVariable("resource") String resource, @RequestBody Map<String, Object> data) {
        JsonResult<Integer> jsonResult = restService.create(resource, data);
        return result(jsonResult, HttpStatus.CREATED);
    }

    @PutMapping("/rest/{permission}/{resource}/{id}")
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable("resource") String resource, @PathVariable("id") Long id, @RequestBody Map<String, Object> data) {
        JsonResult<Integer> jsonResult = restService.update(resource, id, data);
        return result(jsonResult);
    }

    @DeleteMapping("/rest/{permission}/{resource}/{id}")
    public ResponseEntity<JsonResult<Integer>> deleteById(@PathVariable("resource") String resource, @PathVariable("id") Long id) {
        JsonResult<Integer> jsonResult = restService.deleteById(resource, id);
        return result(jsonResult);
    }
}