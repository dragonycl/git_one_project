package com.usian.Interceptor;

import com.usian.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            System.out.println(user);
            return true;
        }else{
            request.setAttribute("e","没有登录，请先登录");
            request.getRequestDispatcher("/student/login").forward(request,response);
            return false;
        }
    }
}
