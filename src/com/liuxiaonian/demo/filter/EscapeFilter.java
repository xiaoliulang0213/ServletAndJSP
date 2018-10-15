package com.liuxiaonian.demo.filter;

import com.liuxiaonian.demo.wrapper.EncodingAndEscapeWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class EscapeFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException { }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if ("GET".equals(httpServletRequest.getMethod())){
            httpServletRequest = new EncodingAndEscapeWrapper((HttpServletRequest) servletRequest,"UTF-8");
        }if ("POST".equals(httpServletRequest.getMethod())){
            httpServletRequest.setCharacterEncoding("UTF-8");
        }else {

        }
        filterChain.doFilter(httpServletRequest,servletResponse);
    }
    public void destroy() { }
}
