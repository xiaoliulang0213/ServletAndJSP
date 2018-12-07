<%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/12/7
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <fmt:timeZone value="GMT+1:00">
            <fmt:formatDate value="${now}"></fmt:formatDate><br/>
        </fmt:timeZone>
        <fmt:formatDate value="${now}" dateStyle="default"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" dateStyle="short"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" dateStyle="medium"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" dateStyle="long"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" dateStyle="full"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" type="time" timeStyle="default"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" type="time" timeStyle="short"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" type="time" timeStyle="medium"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" type="time" timeStyle="long"></fmt:formatDate><br/>
        <fmt:formatDate value="${now}" type="time" timeStyle="full"></fmt:formatDate><br/>
        <h1>数字格式化</h1>
        <fmt:formatNumber value="12345.678"></fmt:formatNumber><br/>
        <fmt:formatNumber value="12345.678" type="number"></fmt:formatNumber><br/>
        <fmt:formatNumber value="12345.678" type="currency" currencySymbol="$"></fmt:formatNumber><br/>
        <fmt:formatNumber value="12345.678" type="percent"></fmt:formatNumber><br/>
        <fmt:formatNumber value="12345.678" pattern="#,#00.0#"></fmt:formatNumber><br/>
        <h1>日期解析</h1>
        <fmt:parseDate value="2018-12-07" type="date" pattern="yyyy-MM-dd">

        </fmt:parseDate>
    </body>
</html>
