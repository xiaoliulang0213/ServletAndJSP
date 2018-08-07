package com.liuxiaonian.httpservletrequest.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/bodyView")
public class BodyViewServlet extends HttpServlet {

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException,IOException{
        String body = readBody(httpServletRequest);
        int local1 = body.lastIndexOf("=");
        int local2 = body.lastIndexOf("&");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Body View</title>");
        printWriter.println("<body>");
        printWriter.println(body.substring(0,local2));
        printWriter.println("<hr/>");
        printWriter.println(new String(body.substring(local1+1).getBytes(),"UTF-8"));
        printWriter.println("</body>");
        printWriter.println("</head>");
        printWriter.println("</html>");
        printWriter.close();
    }

    private String readBody(HttpServletRequest httpServletRequest) throws IOException{
        BufferedReader bufferedReader = httpServletRequest.getReader();
        String input = null;
        String requestBoyd = "";
        while ((input = bufferedReader.readLine()) != null){
            requestBoyd = requestBoyd+input+"<br/>";
        }
        return requestBoyd;
    }
}
