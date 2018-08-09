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
        //���email��ʽ�Ƿ���ȷ
        if(checkEmailFormat(user.getEmail())){
            errors.add("Email�ĸ�ʽ����ȷ");
        }
        //����û��Ƿ��Ѿ�������
        if (checkUserName(user.getUserName())){
            errors.add("���û��Ѿ�ע�ᣬ�����ظ�ע��");
        }
        String resultPage = ERROR_VIEW;
        //��ҳ�淵�ش���
        if (!errors.isEmpty()){
            req.setAttribute("errors",errors);
        }else {
            //�����û�����
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
     * @Description ���email��ʽ�Ƿ���ȷ
     * @Date 20:30 2018/8/8
     * @Param [email]
     * @return boolean
     **/
    private boolean checkEmailFormat(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }

    /**
     * @Author chengpunan
     * @Description ����û����Ƿ��Ѿ���ע��
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
     * @Description �����û�����
     * @Date 20:28 2018/8/8
     * @Param [user]
     * @return void
     **/
    private boolean saveUserInformation(User user) {
        File userFile = new File(filePath+"/"+user.getUserName());
        //����File��������Ŀ¼�Լ�������ĸ�Ŀ¼
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
