package com.liuxiaonian.async;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

public class AsyncRequest implements Runnable {
    private AsyncContext asyncContext;
    public AsyncRequest(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    public void run() {
        try {
            //模拟请求阻塞
            Thread.sleep(10000);
            //阻塞之后完成响应
            PrintWriter printWriter = asyncContext.getResponse().getWriter();
            printWriter.println("久等了...");
            //提交响应
            asyncContext.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
