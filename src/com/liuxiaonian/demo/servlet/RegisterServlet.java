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
     * @Description ʵ���û�ע��
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
        //��ȡUserService����
        UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
        if (userServiceImpl.isInvalidUsername(user.getUserName())){
            errors.add("���û��Ѿ�ע�ᣬ�����ظ�ע��");
        }
        if(Utils.checkEmailFormat(user.getEmail())){
            errors.add("Email�ĸ�ʽ����ȷ");
        }
        //��Ӧ
        String resultPage = error_view;
        //��ҳ�淵�ش���
        if (!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else {
            resultPage = success_view;
            //�����û�����
            userServiceImpl.createUserData(user.getEmail(),user.getUserName(),user.getPassword(),user.getPhone());
        }
        req.getRequestDispatcher(resultPage).forward(req,resp);
    }
}
