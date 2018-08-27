package com.liuxiaonian.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(value = "/demo/delete")
public class DeleteController extends HttpServlet{
    private final String filePath = "e:/userInformation";
    private final String LOGIN_VIEW = "/ServletAndJSP/demo/login/loginManage.html";
    private final String SUCCESS_VIEW = "main";

    //É¾³ý¶¯Ì¬
    private void delete(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
            throws IOException,ServletException{
        if (httpServletRequest.getSession().getAttribute("userName") == null){
            httpServletResponse.sendRedirect(LOGIN_VIEW);
            return;
        }
        String userName =(String) httpServletRequest.getSession().getAttribute("userName");
        String message = httpServletRequest.getParameter("message");
        File file = new File(filePath+"/"+userName+"/"+message+".txt");
        if (file.exists()){
            file.delete();
        }
        httpServletResponse.sendRedirect(SUCCESS_VIEW);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }
}
