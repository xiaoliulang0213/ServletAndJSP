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
                //��ת����ԭ����������10�֣���Ҫ���ݷ��ص���Ա��ҳ(��Ҫ��ͬһ�����󣬹���ת��)��
                // �ڻ�Ա��ҳ�ж������Ƿ�Ϊ�գ������Ϊ�����ʾ��������������
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
