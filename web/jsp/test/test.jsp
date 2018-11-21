<%@page import="javax.servlet.*,com.liuxiaonian.demo.data.User" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <!--测试jsp:include标准标签-->
        <jsp:include page="include.jsp">
            <jsp:param name="userName" value="1"></jsp:param>
        </jsp:include>
        <!---测试jsp:useBean标签->
        <!--创建User对象-->
        <jsp:useBean id="user" class="com.liuxiaonian.demo.data.User">
            <jsp:setProperty name="user" property="userName" value="刘小念"></jsp:setProperty>
        </jsp:useBean>
        <div>
            <jsp:getProperty name="user" property="userName"></jsp:getProperty>
        </div>
    </body>
</html>
