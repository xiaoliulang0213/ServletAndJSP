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
                //��ת����ԭ����������10�֣���Ҫ���ݷ��ص���Ա��ҳ(��Ҫ��ͬһ�����󣬹���ת��)��
                // �ڻ�Ա��ҳ�ж������Ƿ�Ϊ�գ������Ϊ�����ʾ��������������
                req.getRequestDispatcher(main_view).forward(req,resp);
            }
        }else {
            resp.sendRedirect(main_view);
        }
    }
}
