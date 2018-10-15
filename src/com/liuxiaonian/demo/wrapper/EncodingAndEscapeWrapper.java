package com.liuxiaonian.demo.wrapper;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class EncodingAndEscapeWrapper extends HttpServletRequestWrapper{

    private String encoding;

    public EncodingAndEscapeWrapper(HttpServletRequest request,String encoding) {
        super(request);
        this.encoding = encoding;
    }

    public String getParameter(String name){
        String result = getRequest().getParameter(name);
        if (result != null){
            result = StringEscapeUtils.escapeHtml4(result);
            try {
                byte[]  temp = result.getBytes("ISO-8859-1");
                result = new String(temp,encoding);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
