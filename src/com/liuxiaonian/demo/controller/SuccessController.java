package com.liuxiaonian.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo/success.view")
public class SuccessController extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta content='text/html;charset=UTF-8' http-equiv='content-type'>");
        printWriter.println("<title>��Աע��ɹ�</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>��Ա"+req.getParameter("userName")+"ע��ɹ�</h1>");
        printWriter.println("<a href='/ServletAndJSP/demo/login/loginManage.html'>���ص�¼ҳ��</a>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
