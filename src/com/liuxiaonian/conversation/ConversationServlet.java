package com.liuxiaonian.conversation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/conversation")
public class ConversationServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        int count = 0;
        if (req.getSession().getAttribute("count") != null){
            Integer c =(Integer) req.getSession().getAttribute("count");
            count = c + 1;
        }
        req.getSession().setAttribute("count",count);
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Conversation Servlet</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>Servlet Count:"+count+"</h1>");
        printWriter.println("<a href='"+resp.encodeURL("conversation")+"'>µÝÔö</a>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
