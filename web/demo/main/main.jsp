<%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/11/20
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName =(String) request.getSession().getAttribute("userName");
%>
<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="content-type">
        <title>Gossip 微博</title>
        <link rel="stylesheet" href="../../css/demo.css" type="text/css">
    </head>
    <body>
        <div>
            <a href="logout.do?username="<%=userName%>>
                注销<%=userName%>
        </div>
        <form method="post" action="message.do">

        </form>
    </body>
</html>
