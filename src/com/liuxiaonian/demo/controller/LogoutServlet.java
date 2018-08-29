package com.liuxiaonian.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet{
    private static final String LOGIN_VIEW = "/ServletAndJSP/demo/login/loginManage.html";

    /**
     * @Author chengpunan
     * @Description 实现注销功能
     * @Date 11:33 2018/8/29
     * @Param [httpServletRequest, httpServletResponse]
     * @return void
     **/
    private void logout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
            throws ServletException,IOException{
        if (httpServletRequest.getSession().getAttribute("userName") != null){
            httpServletRequest.getSession().invalidate();
        }
        httpServletResponse.sendRedirect(LOGIN_VIEW);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }
}
