package com.liuxiaonian.SimpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class WhenTag extends SimpleTagSupport{
    private boolean test;

    public void setTest(boolean test){
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspTag parent = getParent();
        //parent instanceof  ChooseTag：判断parent是否是ChooseTag的实例
        if (!(parent instanceof  ChooseTag)){
            throw new JspTagException("必须置于choose标签中使用");
        }
        ChooseTag choose =(ChooseTag) parent;
        if (!choose.isMatched() && test){
            choose.setMatched(true);
            this.getJspBody().invoke(null);
        }
    }
}
