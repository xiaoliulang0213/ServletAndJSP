package com.liuxiaonian.demo.servlet;

import com.liuxiaonian.demo.data.User;
import com.liuxiaonian.demo.service.impl.UserServiceImpl;
import com.liuxiaonian.demo.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
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

@WebServlet(urlPatterns = {"/demo/register"},
        initParams = {
            @WebInitParam(name = "SUCCESS_VIEW",value = "success.view"),
            @WebInitParam(name = "ERROR_VIEW",value = "error.view")
        })
public class RegisterServlet extends HttpServlet{
    private String error_view;
    private String success_view;

    public void init() throws ServletException{
        success_view = getServletConfig().getInitParameter("SUCCESS_VIEW");
        error_view = getServletConfig().getInitParameter("ERROR_VIEW");
    }

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
        //获取UserService对象
        UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
        if (userServiceImpl.isInvalidUsername(user.getUserName())){
            errors.add("该用户已经注册，不可重复注册");
        }
        if(Utils.checkEmailFormat(user.getEmail())){
            errors.add("Email的格式不正确");
        }
        //响应
        String resultPage = error_view;
        //向页面返回错误
        if (!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else {
            resultPage = success_view;
            //保存用户资料
            userServiceImpl.createUserData(user.getEmail(),user.getUserName(),user.getPassword(),user.getPhone());
        }
        req.getRequestDispatcher(resultPage).forward(req,resp);
    }
}
