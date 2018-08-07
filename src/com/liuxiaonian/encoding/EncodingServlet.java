package com.liuxiaonian.encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/encoding/*")
public class EncodingServlet extends HttpServlet{

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException,IOException{
        String name = httpServletRequest.getParameter("nameGet");
        byte[] temp = name.getBytes("ISO-8859-1");
        name = new String(temp,"GBK");
        System.err.println(name);
    }

    public void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
            throws ServletException,IOException{
        httpServletRequest.setCharacterEncoding("GBK");
        String name = httpServletRequest.getParameter("namePost");
        System.err.println(name);
    }
}
