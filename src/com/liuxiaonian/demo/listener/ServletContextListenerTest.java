package com.liuxiaonian.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener{
    //WEBӦ�ó����ʼ��
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println("aaa");
    }
    //WEBӦ�ó�������֮ǰ
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
