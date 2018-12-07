<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/12/6
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="count" value="${sessionScope.count + 1}" scope="session"></c:set>
<c:set var="count" value="${user}" scope="session"></c:set>
<c:set target="${user}" var="name" value="demo"></c:set>
<c:remove var="count" scope="session"></c:remove>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:if test="${param.name == 'demo' && param.password ==  '123'}">
            <h1>${param.name}登陆成功</h1>
        </c:if>

        <c:choose>
            <c:when test="${param.name == 'demo'}">
                <h1>Demo登陆</h1>
            </c:when>
            <c:otherwise>
                <h1>其他登陆</h1>
            </c:otherwise>
        </c:choose>

        <c:forEach var="str" items="a,b,c,d,e,f">
            <h1>${str}</h1>
        </c:forEach>
        <%--<c:forTokens var="str" delims=":" items="a:b:c:d:e:f:g">--%>
            <%--<h1>${str}</h1>--%>
        <%--</c:forTokens>--%>

        <c:catch var="error">
            ${param.a}+${param.b} = ${param.a+param.b}
        </c:catch>
        <c:if test="${error != null}">
            <span style="color: red">${error.message}</span><br/>
            ${error}
        </c:if>

        <c:import url="http://www.baidu.com" charEncoding="UTF-8">
            <c:param name="a" value="1"></c:param>
        </c:import>

        <c:if test="${param.a == 1}">
            <c:redirect url="http://www.baidu.com">
                <c:param name="a" value="1"></c:param>
            </c:redirect>
        </c:if>

        <h1>Session Count: ${sessionScope.count}</h1>
        <a href="<c:url value='jstl_core.jsp'><c:param name='a' value='2'/></c:url>">递增</a>

        <c:out value="${param.out}" default="default" />
    </body>
</html>
