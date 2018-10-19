package com.liuxiaonian.demo.servlet;

import com.liuxiaonian.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;
import java.util.Date;

@WebServlet(urlPatterns = {"/demo/message"},
    initParams = {
        @WebInitParam(name = "MAIN_VIEW",value = "/demo/main")
    })
public class MessageServlet extends HttpServlet{
    private String main_view;

    public void init() throws ServletException{
        this.main_view = getServletConfig().getInitParameter("MAIN_VIEW");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String blabla = req.getParameter("blabla");
        if (blabla != null && blabla.length() !=0){
            if (blabla.length() < 100){
                UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
                String userName =(String) req.getSession().getAttribute("userName");
                userServiceImpl.addMessage(userName, blabla);
                resp.sendRedirect(main_view);
            }else {
                //用转发的原因：字数超过10字，需要内容返回到会员网页(需要是同一个请求，故用转发)，
                // 在会员网页判断内容是否为空，如果不为空则表示字数不符合条件
                req.getRequestDispatcher(main_view).forward(req,resp);
            }
        }else {
            resp.sendRedirect(main_view);
        }
    }
}
