package com.liuxiaonian.demo.servlet;

import com.liuxiaonian.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

@WebServlet(value = "/demo/main")
public class MainServlet extends HttpServlet{

    private void loginSuccess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>会员登录成功</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>会员"+req.getSession().getAttribute("userName")+"你好</h1><a href='/demo/logout'>注销</a><br/>");
        printWriter.println("<form method='post' action = '/demo/message'><br/>");
        printWriter.println("分享新鲜事....<br/>");
        String blabla = req.getParameter("blabla");
        if (blabla == null){
            blabla = "";
        }else {
            printWriter.println("<span style='color:red'>信息要100字之内</span><br/>");
        }
        printWriter.println("<textarea cols='60' rows='4' name='blabla'></textarea><br/>");
        printWriter.println("<button type='submit'>送出</button>");
        printWriter.println("</form>");
        printWriter.println("<tbody>");
        UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
        Map<Date,String> messages = userServiceImpl.readMessage((String) req.getSession().getAttribute("userName"));
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, Locale.CHINA);
        for (Date date: messages.keySet()){
            printWriter.println("<tr><td style='vertical-align:top;'>");
            printWriter.println((String) req.getSession().getAttribute("userName")+"<br>");
            printWriter.println(messages.get(date)+"<br>");
            printWriter.println(dateFormat.format(date));
            printWriter.println("<a href='/demo/delete?message="+date.getTime()+"'>删除</a>");
            printWriter.println("<hr></td></tr>");
        }
        printWriter.println("</tbody>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginSuccess(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginSuccess(req, resp);
    }
}
