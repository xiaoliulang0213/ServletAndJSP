package com.liuxiaonian.httpservletrequest.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(value = "/incloud")
public class IncloudServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = (Date) req.getAttribute("date");
        PrintWriter writer = resp.getWriter();
        writer.println("IncloudServlet");
    }
}
