package com.liuxiaonian.listerner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionListenerTest implements HttpSessionListener{

    /**
     * @Author chengpunan
     * @Description 创建Session时调用
     * @Date 10:11 2018/9/4
     * @Param [se]
     * @return void
     **/
    public void sessionCreated(HttpSessionEvent se) {
    }
    /**
     * @Author chengpunan
     * @Description 销魂Session时调用
     * @Date 10:12 2018/9/4
     * @Param [se]
     * @return void
     **/
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
