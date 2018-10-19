package com.liuxiaonian.demo.servlet;

import com.liuxiaonian.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = {"/demo/delete"},
    initParams = {
        @WebInitParam(name = "MAIN_VIEW",value = "main")
    })
public class DeleteServlet extends HttpServlet{
    private String main_view;

    public void init() throws ServletException{
        this.main_view = getServletConfig().getInitParameter("MAIN_VIEW");
    }
    /**
     * @Author chengpunan
     * @Description É¾³ý¶¯Ì¬
     * @Date 15:19 2018/10/19
     * @Param [httpServletRequest, httpServletResponse]
     * @return void
     **/
    private void delete(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
            throws IOException,ServletException{
        String userName =(String) httpServletRequest.getSession().getAttribute("userName");
        String message = httpServletRequest.getParameter("message");
        UserServiceImpl userServiceImpl = (UserServiceImpl) getServletContext().getAttribute("userService");
        userServiceImpl.deleteMessage(userName,message);
        httpServletResponse.sendRedirect(main_view);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        delete(req, resp);
    }
}
