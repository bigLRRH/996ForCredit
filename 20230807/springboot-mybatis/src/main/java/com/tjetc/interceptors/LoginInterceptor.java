package com.tjetc.interceptors;

import com.alibaba.fastjson2.JSONObject;
import com.tjetc.common.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //访问controller方法之前先执行preHandle，所以可以作为是否登录的判断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//设置中文字符编码与返回类型
        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        获取session对象
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            JsonResult result = new JsonResult(-1, "请先登录", null);
//            把result对象转换成json字符串
            String json = JSONObject.toJSONString(result);
//            把json的字符串输出到前端就可以了
            response.getWriter().write(json);
//不放行，就意味着不能再访问controller对应的方法了
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
