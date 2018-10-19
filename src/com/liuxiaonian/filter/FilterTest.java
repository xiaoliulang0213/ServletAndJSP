package com.liuxiaonian.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "FilterTest",urlPatterns = "/*")
public class FilterTest implements Filter{
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        filterConfig.getServletContext().log("Ê±¼ä²îÎª:"+(System.currentTimeMillis()-begin)+"milliseconds");
    }
    public void destroy() {

    }
}