package com.liuxiaonian.demo.listerner;

import com.liuxiaonian.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WeBoListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent servletContextEvent){
        ServletContext servletContext = servletContextEvent.getServletContext();
        String filePath =servletContext.getInitParameter("filePath");
        //����UserServiceImpl������������Ŀ�ж����õ������Խ������ServletContext������
        servletContext.setAttribute("userService",new UserServiceImpl(filePath));
    }
    public void contextDestroyed(ServletContextEvent sce) { }
}
