package com.liuxiaonian.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/demo/logout"},
        initParams = {
            @WebInitParam(name = "LOGIN_VIEW",value = "/demo/login/loginManage.html")
        })
public class LogoutServlet extends HttpServlet{
    private String login_view;

    public void init() throws ServletException{
        this.login_view = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

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
        httpServletResponse.sendRedirect(login_view);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }
}
