package com.liuxiaonian.ServletConfig;

import javax.jws.soap.InitParam;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(value = "/ServletConfig",
//    initParams = {
//        @WebInitParam(name = "name1",value = "value1"),
//        @WebInitParam(name = "name2",value = "value2")
//    })
public class ServletConfigServlet extends HttpServlet{
    private String name1;
    private String name2;
    public void init() throws ServletException{
        name1 = getServletConfig().getInitParameter("name1");
        name2 = getServletConfig().getInitParameter("name2");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println(name1);
        System.err.println(name2);
    }
}
