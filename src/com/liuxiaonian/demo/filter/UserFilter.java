package com.liuxiaonian.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/demo/delete","/demo/logout","/demo/message"},
            initParams = {@WebInitParam(name = "LOGIN_VIEW",value = "/ServletAndJSP/demo/login/loginManage.html")})
public class UserFilter implements Filter {
    private String login_view;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.login_view = filterConfig.getInitParameter("LOGIN_VIEW");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
        if (httpServletRequest.getSession().getAttribute("userName") != null){
            //只有在Session中具备了用户名的时候才执行请求
            filterChain.doFilter(httpServletRequest,servletResponse);
        }else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect(login_view);
        }
    }

    public void destroy() { }
}
