package com.liuxiaonian.filter;

import com.liuxiaonian.demo.wrapper.CompressionWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

//@WebFilter(urlPatterns = "/*",asyncSupported = true)
public class CompressionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String encodings = httpServletRequest.getHeader("accept-encoding");
        if (encodings != null && encodings.indexOf("gzip") > -1){
            CompressionWrapper compressionWrapper = new CompressionWrapper(httpServletResponse);
            compressionWrapper.setHeader("content-encoding","gzip");
            filterChain.doFilter(httpServletRequest,compressionWrapper);
            GZIPOutputStream gzipOutputStream = compressionWrapper.getGZIPOutputStream();
            if (gzipOutputStream != null){
               gzipOutputStream.finish();
            }
        }else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
