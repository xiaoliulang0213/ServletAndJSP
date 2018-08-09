package com.liuxiaonian.demo.controller;

import com.liuxiaonian.demo.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/demo/register")
public class RegisterServlet extends HttpServlet{

    private final String filePath = "e:/userInformation";
    private final String ERROR_VIEW = "error.view";
    private final String SUCCESS_VIEW = "success.view";

    /**
     * @Author chengpunan
     * @Description 实现用户注册
     * @Date 9:41 2018/8/7
     * @Param [req, resp]
     * @return void
     **/
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        List<String> errors = new ArrayList<>();
        //检查email格式是否正确
        if(checkEmailFormat(user.getEmail())){
            errors.add("Email的格式不正确");
        }
        //检查用户是否已经被创建
        if (checkUserName(user.getUserName())){
            errors.add("该用户已经注册，不可重复注册");
        }
        String resultPage = ERROR_VIEW;
        //向页面返回错误
        if (!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else {
            //保存用户资料
            boolean flag = saveUserInformation(user);
            resultPage = SUCCESS_VIEW;
            if (!flag){
                resultPage = ERROR_VIEW;
            }
        }
        req.getRequestDispatcher(resultPage).forward(req,resp);
    }

    /**
     * @Author chengpunan
     * @Description 检查email格式是否正确
     * @Date 20:30 2018/8/8
     * @Param [email]
     * @return boolean
     **/
    private boolean checkEmailFormat(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }

    /**
     * @Author chengpunan
     * @Description 检查用户名是否已经被注册
     * @Date 10:09 2018/8/9
     * @Param [userName]
     * @return boolean
     **/
    private boolean checkUserName(String userName){
        String[] files = new File(filePath).list();
        if(files != null){
            for (String fileName : files){
                if (fileName.equals(userName)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * @Author chengpunan
     * @Description 保存用户资料
     * @Date 20:28 2018/8/8
     * @Param [user]
     * @return void
     **/
    private boolean saveUserInformation(User user) {
        File userFile = new File(filePath+"/"+user.getUserName());
        //创建File对象所在目录以及所必需的父目录
        userFile.mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(userFile+"/profile"));
            bufferedWriter.write("userName:"+user.getUserName()+"\n"+"password:"
                    +user.getPassword()+"\n"+"phone:"+user.getPhone()+"\n"+"email:"+user.getEmail());
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
