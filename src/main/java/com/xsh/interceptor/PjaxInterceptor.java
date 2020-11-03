
package com.xsh.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@Component
public class PjaxInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(PjaxInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        Boolean pjax = Boolean.parseBoolean(request.getHeader("X-PJAX"));

        logger.info("is pjax: {}", pjax);
/*        if (pjax) {
            modelAndView.addObject("isPjax", true);
        } else {
            modelAndView.addObject("isPjax", false);
        }*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

