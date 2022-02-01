package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        String url = req.getRequestURI();
        //获取请求路径的最后路径
        int i = url.lastIndexOf("/");
        String methodName = url.substring(i + 1);
        //谁调用，就获取谁,
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            //根据方法名和参数获取this对应的方法
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
