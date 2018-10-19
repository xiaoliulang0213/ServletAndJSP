package com.liuxiaonian.demo.servlet;


import com.liuxiaonian.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

@WebServlet(urlPatterns ={"/demo/login"},
        initParams = {
            @WebInitParam(name = "SUCCESS_VIEW",value = "main"),
            @WebInitParam(name = "ERROR_VIEW",value = "error.view")
        })
public class LoginServlet extends HttpServlet{
    private String success_view;
    private String error_view;

    public void init() throws ServletException{
        success_view = getServletConfig().getInitParameter("SUCCESS_VIEW");
        error_view = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    private void loginRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        List<String> errors = new ArrayList<>();
        if (userName == null || password == null){
            errors.add("入口参数为空");
        }
        UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
        if (userServiceImpl.checkLogin(userName,password)){
            req.getSession().setAttribute("userName",userName);
            req.getRequestDispatcher(success_view).forward(req,resp);
        }else {
            errors.add("用户不存在或用户名密码不匹配");
            req.setAttribute("errors",errors);
            req.getRequestDispatcher(error_view).forward(req,resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginRequest(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginRequest(req,resp);
    }
}
