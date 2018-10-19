package com.liuxiaonian.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/asyncServlet",asyncSupported = true)
public class AsyncServlet extends HttpServlet{
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //��ʼ�첽�����ͷ������߳�
        AsyncContext asyncContext = req.startAsync();
        executorService.submit(new AsyncRequest(asyncContext));
    }

    public void destroy(){
        executorService.shutdown();
    }
}
