package com.liuxiaonian.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class OtherwiseTag extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
        JspTag parent = getParent();
        if (!(parent instanceof ChooseTag)){
            throw new JspTagException("必须置于choose标签中使用");
        }
        ChooseTag choose = (ChooseTag) parent;
        if (!choose.isMatched()){
            this.getJspBody().invoke(null);
        }
    }
}
