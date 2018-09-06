package com.liuxiaonian.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener{
    //WEB应用程序初始化
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println("aaa");
    }
    //WEB应用程序销毁之前
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
