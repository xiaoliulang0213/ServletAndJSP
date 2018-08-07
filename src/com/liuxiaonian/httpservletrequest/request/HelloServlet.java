package com.liuxiaonian.httpservletrequest.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "HelloServlet",urlPatterns = "/hello/*",loadOnStartup = 1)
public class HelloServlet extends HttpServlet{
    /**
     * @Author chengpunan
     * @Description //响应Get请求
     * @Date 18:02 2018/4/12
     * @Param [req, resp]
     * @return void
     **/
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取单个参数
        String name = req.getParameter("name");
        //获取多个参数
        String names[] = req.getParameterValues("name");
        //获取所有参数名
        Enumeration<String> enumeration = req.getParameterNames();
        //获取所有参数
        Map<String,String[]> param = req.getParameterMap();
        //获取请求编码
        String requestEncoding = req.getCharacterEncoding();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Hello Servlet</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        //查看请求参数
        printWriter.println("<h1>"+name+"</h1>");
        //查看所有请求头
        printWriter.println("Show All RequestHeaders:<br/>");
        Enumeration<String> enumeration1 = req.getHeaderNames();
        while (enumeration1.hasMoreElements()){
            String headerName = enumeration1.nextElement();
            printWriter.println("headerName:"+headerName+"---headerValue:"+req.getHeader(headerName)+"<br/>");
        }
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
        System.err.println(req.getRequestURI());
        System.err.println(req.getContextPath());
        System.err.println(req.getServletPath());
        System.err.println(req.getPathInfo());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
