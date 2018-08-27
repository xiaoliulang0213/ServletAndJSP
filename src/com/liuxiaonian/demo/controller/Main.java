package com.liuxiaonian.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

@WebServlet(value = "/demo/main")
public class Main extends HttpServlet{

    private final String LOGIN_VIEW = "/ServletAndJSP/demo/login/loginManage.html";
    private final String filePath = "e:/userInformation";

    private void loginSuccess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("userName") == null){
            resp.sendRedirect(LOGIN_VIEW);
            return;
        }
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>��Ա��¼�ɹ�</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>��Ա"+req.getSession().getAttribute("userName")+"���</h1><br/>");
        printWriter.println("<form method='post' action = '/ServletAndJSP/message'><br/>");
        printWriter.println("����������....<br/>");
        String blabla = req.getParameter("blabla");
        if (blabla == null){
            blabla = "";
        }else {
            printWriter.println("<span style='color:red'>��ϢҪ10��֮��</span><br/>");
        }
        printWriter.println("<textarea cols='60' rows='4' name='blabla'></textarea><br/>");
        printWriter.println("<button type='submit'>�ͳ�</button>");
        printWriter.println("</form>");
        printWriter.println("<tbody>");
        Map<Date,String> messages = readMessage((String) req.getSession().getAttribute("userName"));
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, Locale.CHINA);
        for (Date date: messages.keySet()){
            printWriter.println("<tr><td style='vertical-align:top;'>");
            printWriter.println((String) req.getSession().getAttribute("userName")+"<br>");
            printWriter.println(messages.get(date)+"<br>");
            printWriter.println(dateFormat.format(date));
            printWriter.println("<a href='delete?message="+date.getTime()+"'>ɾ��</a>");
            printWriter.println("<hr></td></tr>");
        }
        printWriter.println("</tbody>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }

    //���˺�׺Ϊtxt���ļ�
    private class TxtFilenameFilter implements FilenameFilter{
        public boolean accept(File dir, String name) {
            return name.endsWith(".txt");
        }
    }
    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();
    //��ʱ������
    private class DateComparator implements Comparator<Date>{
        public int compare(Date o1, Date o2) {
            return -o1.compareTo(o2);
        }
    }
    private DateComparator comparator = new DateComparator();

    //��ȡ��̬�ļ�
    private Map<Date,String> readMessage(String userName) throws IOException{
        File border = new File(filePath+"/"+userName);
        String[] txts = border.list(filenameFilter);
        Map<Date,String> messages = new TreeMap<Date,String>(comparator);
        for (String txt: txts){
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(filePath+"/"+userName+"/"+txt),"UTF-8"));
            String text = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((text = bufferedReader.readLine()) != null){
                stringBuilder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0,txt.indexOf(".txt"))));
            messages.put(date,stringBuilder.toString());
            bufferedReader.close();
        }
        return messages;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginSuccess(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        loginSuccess(req, resp);
    }
}
