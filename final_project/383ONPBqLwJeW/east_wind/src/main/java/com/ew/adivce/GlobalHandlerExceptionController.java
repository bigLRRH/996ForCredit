package com.ew.adivce;

import com.ew.common.response.ResponseData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//局部异常处理（对指定相同的异常）局部优先级高，全局优先低，可以把特有处理逻辑放在局部异常处理公共处理逻辑放到全局异常处理
//全局处理异常对所有的controller的指定异常都会捕获和处理
@RestControllerAdvice//@ControllerAdvice+@ResponseBody
public class GlobalHandlerExceptionController {
    //        @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
//    处理异常上使用Exception这样包含常用的所有异常情况
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseData> handleAllException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseData(-1, "出错了，请联系管理员"));
    }
}