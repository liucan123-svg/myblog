package com.xsh.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //判断session中是否有user,如果为空则是未登录状态
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect("/admin"); //重定向到admin首页
            return false;
        }
        return true;
    }
}
