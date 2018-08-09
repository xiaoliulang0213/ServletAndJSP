package com.liuxiaonian.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/demo/error.view")
public class ErrorController extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta content='text/html;charset=UTF-8¡¯ http-equiv='content-type'>");
        printWriter.println("<title>»áÔ±×¢²áÊ§°Ü</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>»áÔ±×¢²áÊ§°Ü</h1>");
        printWriter.println("<ul style='color: rgb(255,0,0);'");
        List<String> errors = (List<String>) req.getAttribute("errors");
        for (String error: errors){
            printWriter.println("<li>"+error+"</li>");
        }
        printWriter.println("</ul>");
        printWriter.println("<a href='/ServletAndJSP/demo/register/registerManage.html'>·µ»Ø×¢²áÒ³Ãæ</a>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
