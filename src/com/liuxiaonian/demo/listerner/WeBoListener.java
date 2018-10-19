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
        //由于UserServiceImpl对象在整个项目中都会用到，可以将其放在ServletContext对象中
        servletContext.setAttribute("userService",new UserServiceImpl(filePath));
    }
    public void contextDestroyed(ServletContextEvent sce) { }
}
