<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/11/20
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>会员注册失败</title>
    </head>
    <body>
        <h1>会员注册失败</h1>
        <ul style="color: rgb(255,0,0);">
            <%
                List<String> errors =(List<String>) request.getAttribute("errors");
                for (String error: errors){
            %>
            <li><%= error%></li>
            <%
                }
            %>
        </ul>
        <<a href="../register/registerManage.html">返回注册页面</a>
    </body>
</html>
