package com.liuxiaonian.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ChooseTag extends SimpleTagSupport{
    private boolean matched;

    public boolean isMatched(){
        return matched;
    }

    public void setMatched(boolean matched){
        this.matched = matched;
    }

    @Override
    public void doTag() throws JspException, IOException {
        this.getJspBody().invoke(null);
    }
}
