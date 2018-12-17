<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/12/11
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://com.liuxiaonian.simpleTag" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <s:if test="${param.value == '123'}">
            <h1>${param.value}</h1>
        </s:if>

        <%
            List<String> names = new ArrayList<>();
            names.add("张三");
            names.add("李四");
            names.add("王五");
            request.setAttribute("names",names);
        %>

        <s:forEach var="name" items="${requestScope.names}">
            <h2>aaaa</h2>
            <h1>${name}</h1>
        </s:forEach>
        <h3>${name}</h3>

        <s:choose>
            <s:when test="${param.value == '12'}">
                <h1>12</h1>
            </s:when>
            <s:when test="${param.value == '123'}">
                <h1>123</h1>
            </s:when>
            <s:otherwise>
                <h1>1234</h1>
            </s:otherwise>
        </s:choose>
    </body>
</html>
