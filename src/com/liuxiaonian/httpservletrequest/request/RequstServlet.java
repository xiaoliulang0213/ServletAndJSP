package com.liuxiaonian.httpservletrequest.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(value = "/request")
public class RequstServlet extends HttpServlet{

    /**
     * @Author chengpunan
     * @Description ≤‚ ‘œÏ”¶Õ∑
     * @Date 15:19 2018/7/26
     * @Param [req, resp]
     * @return void
     **/
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println(req.getCharacterEncoding());
        Locale locale = req.getLocale();
        resp.setLocale(new Locale("zh"));
        resp.setContentType("text/html;charset=utf-8");
        System.err.println(resp.getCharacterEncoding());
    }
}
