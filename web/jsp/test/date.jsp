<%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/10/30
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page buffer="16kb" %>
<%@page import="java.util.Date" %>
<%@ page import="com.liuxiaonian.demo.data.User" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <%!
            String name = "liuxiaonian";
            public String getName(){
                return name;
            }
        %>
        <%
            //Java注释测试
        %>
        <!---HTML注释测试->
        <%--JSP注释测试--%>
        <h1>当前时间为:<%= new Date()%></h1>
    </body>
</html>
