<%--
  Created by IntelliJ IDEA.
  User: liuxiaonian
  Date: 2018/12/7
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>${fn:length(param.str)}</h1>
    </body>
</html>
