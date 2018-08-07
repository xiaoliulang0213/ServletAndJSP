package com.liuxiaonian.httpservletrequest.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(value = "/dispatcher")
public class DispatcherServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("DispatcherServlet");
//        //��IncloudServlet�������̰�������
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/incloud?name=liuxiaonian");
//        Date date = new Date();
//        req.setAttribute("date",date);
//        dispatcher.include(req,resp);
//        writer.println("DispatcherServlet");
//        writer.close();
        //������ת��������һ��Servlet��
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/forward");
        requestDispatcher.forward(req,resp);
    }
}
