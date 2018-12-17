package com.liuxiaonian.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {
    private boolean test;
    //把<s:if>标签的test的属性赋给成员变量
    public void setTest(boolean test){
        this.test = test;
    }
    //重写doTag方法
    public void doTag() throws IOException, JspException {
        if (test){
            getJspBody().invoke(null);
        }
    }
}
