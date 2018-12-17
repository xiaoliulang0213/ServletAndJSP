package com.liuxiaonian.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

public class ForEachTag extends SimpleTagSupport{
    private String var;
    private Collection items;

    public void setVar(String var){
        this.var = var;
    }

    public void setItems(Collection items){
        this.items = items;
    }

    public void doTag() throws JspException, IOException {
        for (Object o: items){
            this.getJspContext().setAttribute(var,o);
            this.getJspBody().invoke(null);
            this.getJspContext().removeAttribute(var);
        }
    }
}
