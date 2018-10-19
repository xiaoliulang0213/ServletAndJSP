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
            //ģ����������
            Thread.sleep(10000);
            //����֮�������Ӧ
            PrintWriter printWriter = asyncContext.getResponse().getWriter();
            printWriter.println("�õ���...");
            //�ύ��Ӧ
            asyncContext.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
