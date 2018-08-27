package com.liuxiaonian.demo.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/demo/login")
public class LoginController extends HttpServlet{

    private final String filePath = "e:/userInformation";
    private final String ERROR_VIEW = "error.view";
    private final String SUCCESS_VIEW = "main";

    private void loginRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        List<String> errors = new ArrayList<>();
        if (userName == null || password == null){
            errors.add("入口参数为空");
        }
        if (!checkLogin(userName,password)){
            errors.add("用户不存在或用户名与密码不匹配!");
            req.setAttribute("errors",errors);
            req.getRequestDispatcher(ERROR_VIEW).forward(req,resp);
        }else{
            req.getSession().setAttribute("userName",userName);
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req,resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginRequest(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginRequest(req,resp);
    }

    /**
     * @Author chengpunan
     * @Description 检查用户名和密码是否正确
     * @Date 17:05 2018/8/9
     * @Param [userName, password]
     * @return boolean
     **/
    private boolean checkLogin(String userName,String password){
        String[] files = new File(filePath).list();
        for (String fileName: files){
            if (fileName.equals(userName)){
                BufferedReader bufferedReader = null;
                String passwordFile = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(filePath+"/"+fileName+"/profile"));
                    String aaa = bufferedReader.readLine();
                    passwordFile =  bufferedReader.readLine().split(":")[1];
                    if (password.equals(passwordFile)){
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }finally {
                    if (bufferedReader != null){
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return false;
    }
}
