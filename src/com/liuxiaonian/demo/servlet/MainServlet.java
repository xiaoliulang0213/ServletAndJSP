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
        printWriter.println("<title>��Ա��¼�ɹ�</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>��Ա"+req.getSession().getAttribute("userName")+"���</h1><a href='/demo/logout'>ע��</a><br/>");
        printWriter.println("<form method='post' action = '/demo/message'><br/>");
        printWriter.println("����������....<br/>");
        String blabla = req.getParameter("blabla");
        if (blabla == null){
            blabla = "";
        }else {
            printWriter.println("<span style='color:red'>��ϢҪ100��֮��</span><br/>");
        }
        printWriter.println("<textarea cols='60' rows='4' name='blabla'></textarea><br/>");
        printWriter.println("<button type='submit'>�ͳ�</button>");
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
            printWriter.println("<a href='/demo/delete?message="+date.getTime()+"'>ɾ��</a>");
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
