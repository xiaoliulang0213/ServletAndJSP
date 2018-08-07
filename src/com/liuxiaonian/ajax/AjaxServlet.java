package com.liuxiaonian.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AjaxServlet",urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet{
    
    /**
     * @Author chengpunan
     * @Description 接收AJAX请求
     * @Date 10:53 2018/5/18
     * @Param 
     * @return 
     **/
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> result = new HashMap<>();
        result.put("name","刘小念");
        result.put("sex","女");
        result.put("age","25");
        result.put("job","文案员");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(result);
    }
}
