package com.liuxiaonian.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@WebServlet(value = "/message")
public class MessageServlet extends HttpServlet{
    private final String filePath = "e:/userInformation";
    private final String LOGIN_VIEW = "/ServletAndJSP/demo/login/loginManage.html";
    private final String MAIN_VIEW = "demo/main";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("userName") == null){
            resp.sendRedirect(LOGIN_VIEW);
        }
        req.setCharacterEncoding("UTF-8");
        String blabla = req.getParameter("blabla");
        if (blabla != null && blabla.length() !=0){
            if (blabla.length() < 10){
                String userName =(String) req.getSession().getAttribute("userName");
                addMessage(userName,blabla);
                resp.sendRedirect(MAIN_VIEW);
            }else {
                //用转发的原因：字数超过10字，需要内容返回到会员网页(需要是同一个请求，故用转发)，
                // 在会员网页判断内容是否为空，如果不为空则表示字数不符合条件
                req.getRequestDispatcher(MAIN_VIEW).forward(req,resp);
            }
        }else {
            resp.sendRedirect(MAIN_VIEW);
        }
    }

    private void addMessage(String userName,String blabla) throws IOException {
        String file = filePath+"/"+userName+"/"+new Date().getTime()+".txt";
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        bufferedWriter.write(blabla);
        bufferedWriter.close();
    }
}
